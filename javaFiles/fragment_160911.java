<Executor   name="hybrisExecutor"
            namePrefix="hybrisHTTP"
            maxThreads="${tomcat.maxthreads}"
            minSpareThreads="${tomcat.minsparethreads}"
            maxIdleTime="${tomcat.maxidletime}"/>

<Connector  port="${tomcat.http.port}"
            maxHttpHeaderSize="8192"
            maxThreads="${tomcat.maxthreads}"
            protocol="org.apache.coyote.http11.Http11NioProtocol"
            executor="hybrisExecutor"
            enableLookups="false"
            acceptCount="${tomcat.acceptcount}"
            connectionTimeout="20000"
            URIEncoding="UTF-8"
            disableUploadTimeout="true" />

<Connector  port="${tomcat.ssl.port}"
            maxHttpHeaderSize="8192"
            maxThreads="${tomcat.maxthreads}"
            protocol="org.apache.coyote.http11.Http11NioProtocol"
            executor="hybrisExecutor"
            enableLookups="false"
            acceptCount="${tomcat.acceptcount}"
            connectionTimeout="20000"
            disableUploadTimeout="true"
            URIEncoding="UTF-8"
            SSLEnabled="true"
            scheme="https"
            secure="true"
            clientAuth="false"
            sslProtocol="TLS"
            keystoreFile="${catalina.home}/lib/keystore"
            keystorePass="123456" />

<!--
    We explicitly declare the AJP connectors as we want to separate HTTP and SSL traffic and the default connector setting Hybris provides is not good enough.
-->
<Connector  protocol="org.apache.coyote.ajp.AjpNioProtocol"
            executor="hybrisExecutor"
            enableLookups="false"
            acceptCount="${tomcat.acceptcount}"
            connectionTimeout="120000"
            maxThreads="${tomcat.maxthreads}"
            port="${tomcat.ajp.port}"
            proxyPort="${proxy.http.port}"
            redirectPort="${proxy.ssl.port}"
            URIEncoding="UTF-8"
            useIPVHosts="${tomcat.ajp.useipv}" />

<Connector  protocol="org.apache.coyote.ajp.AjpNioProtocol"
            executor="hybrisExecutor"
            enableLookups="false"
            acceptCount="${tomcat.acceptcount}"
            connectionTimeout="120000"
            maxThreads="${tomcat.maxthreads}"
            port="${tomcat.ajp.secureport}"
            proxyPort="${proxy.ssl.port}"
            redirectPort="${proxy.http.port}"
            scheme="https"
            secure="true"
            URIEncoding="UTF-8"
            useIPVHosts="${tomcat.ajp.useipv}" />