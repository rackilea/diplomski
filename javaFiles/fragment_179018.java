<cfcomponent output="no">

    <cffunction name="init" access="public" returntype="HttpForwardRequest" output="no">
        <cfargument name="url" type="string" required="yes" hint="The URL to which the request should be forwarded to.">
        <cfargument name="requestHeaders" type="struct" required="yes" hint="The HTTP request headers.">
        <cfargument name="response" type="any" required="yes" hint=" The servlet's response object.">
        <cfargument name="responseHeaders" type="struct" required="no" default="#{}#" hint="Custom response headers to override the initial request response headers.">

        <cfset variables.instance = {
            url = arguments.url,
            requestHeaders = arguments.requestHeaders,
            response = arguments.response,
            responseHeaders = arguments.responseHeaders
        }>

        <cfreturn this>
    </cffunction>

    <cffunction name="send" access="public" returntype="void" output="no">
        <cfset var response = variables.instance.response>
        <cfset var outputStream = response.getOutputStream()>
        <cfset var buffer = createBuffer()>

        <cftry>

            <cfset var connection = createObject('java', 'java.net.URL')
                    .init(variables.instance.url)
                    .openConnection()>

            <cfset setRequestHeaders(connection)>

            <cfset setResponseHeaders(connection)>

            <cfset var inputStream = connection.getInputStream()>

            <cfset response.setStatus(connection.getResponseCode(), connection.getResponseMessage())>

            <cfloop condition="true">
                <cfset var bytesRead = inputStream.read(buffer, javaCast('int', 0), javaCast('int', arrayLen(buffer)))>

                <cfif bytesRead eq -1>
                    <cfbreak>
                </cfif>

                <cftry>
                    <cfset outputStream.write(buffer, javaCast('int', 0), bytesRead)>

                    <cfset outputStream.flush()>

                    <!--- 
                    Connection reset by peer: socket write error

                    The above error occurs when users are seeking a video.
                    That is probably normal since I assume the client (e.g. Window Media Player) 
                    closes the connection when seeking.
                    --->
                    <cfcatch type="java.net.SocketException">
                        <cfbreak>
                    </cfcatch>
                </cftry>
            </cfloop>

            <cffinally>

                <cfif not isNull(inputStream)>
                    <cfset inputStream.close()>
                </cfif>

                <cfif not isNull(connection)>
                    <cfset connection.disconnect()>
                </cfif>

            </cffinally>
        </cftry>

    </cffunction>

    <cffunction name="setRequestHeaders" access="private" returntype="void" output="no">

        <cfargument name="connection" type="any" required="yes">

        <cfset var requestHeaders = variables.instance.requestHeaders>

        <cfloop collection="#requestHeaders#" item="local.key">
            <cfset arguments.connection.setRequestProperty(key, requestHeaders[key])>
        </cfloop>

    </cffunction>

    <cffunction name="setResponseHeaders" access="private" returntype="void" output="no">
        <cfargument name="connection" type="any" required="yes">

        <cfset var response = variables.instance.response>
        <cfset var responseHeaders = variables.instance.responseHeaders>
        <cfset var i = -1>

        <!--- Copy connection headers --->
        <cfloop condition="true">

            <cfset i = javaCast('int', i + 1)>

            <cfset var key = arguments.connection.getHeaderFieldKey(i)>

            <cfset var value = arguments.connection.getHeaderField(i)>

            <cfif isNull(key)>
                <cfif isNull(value)>
                    <!--- Both, key and value are null, break --->
                    <cfbreak>
                </cfif>

                <!--- Sometimes the key is null but the value is not, just ignore and keep iterating --->
                <cfcontinue>
            </cfif>

            <cfset setResponseHeader(key, value)>
        </cfloop>

        <!--- Apply custom headers --->
        <cfloop collection="#responseHeaders#" item="key">
            <cfset setResponseHeader(key, responseHeaders[key])>
        </cfloop>

    </cffunction>

    <cffunction name="setResponseHeader" access="private" returntype="void" output="no">
        <cfargument name="key" type="string" required="yes">
        <cfargument name="value" type="string" required="yes">

        <cfset var response = variables.instance.response>

        <cfif arguments.key eq 'Content-Type'>
            <cfset response.setContentType(arguments.value)>
        <cfelse>
            <cfset response.setHeader(arguments.key, arguments.value)>
        </cfif>
    </cffunction>

    <cffunction name="createBuffer" access="private" returntype="any" output="no">
        <cfreturn repeatString("12345", 1024).getBytes()>
    </cffunction>

</cfcomponent>