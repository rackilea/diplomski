<cffunction name="stream" access="public" returntype="void">
    <cfargument name="file" type="string" required="yes">
    <cfargument name="mimeType" type="string" required="no">

    <cfscript>
        var fileName = getFileFromPath(arguments.file);
        var resolvedMimeType = structKeyExists(arguments, 'mimeType')? arguments.mimeType : this.getMimeType(fileName);
        var javaInt0 = javaCast('int', 0);
        var response = getPageContext().getResponse().getResponse();
        var binaryOutputStream = response.getOutputStream();
        var bytesBuffer = repeatString('11111', 1024).getBytes();
        var fileInputStream = createObject('java', 'java.io.FileInputStream').init(javaCast('string', getRootPath() & arguments.file));

        getPageContext().setFlushOutput(javaCast('boolean', false));

        response.resetBuffer();
        response.setContentType(javaCast('string', resolvedMimeType));

        try {
            while (true) {
                bytesRead = fileInputStream.read(bytesBuffer, javaInt0, javaCast('int', arrayLen(bytesBuffer)));

                if (bytesRead eq -1) break;

                binaryOutputStream.write(bytesBuffer, javaInt0, javaCast('int', bytesRead));
                binaryOutputStream.flush();
            }               
            response.reset();
         } finally {
             if (not isNull(fileInputStream)) fileInputStream.close();
             if (not isNull(binaryOutputStream)) binaryOutputStream.close();
         }
    </cfscript>
</cffunction>