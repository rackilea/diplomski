set.JBOSS_HOME={your jboss home dir}
set.JAVA_HOME={path to the jvm}

wrapper.java.command=%JAVA_HOME%\bin\java

wrapper.java.mainclass=org.tanukisoftware.wrapper.WrapperSimpleApp

wrapper.java.classpath.1=%JBOSS_HOME%/jboss-modules.jar
wrapper.java.classpath.2=%JBOSS_HOME%/lib/wrapper.jar

# Java Library Path (location of Wrapper.DLL or libwrapper.so)
wrapper.java.library.path.1=%JBOSS_HOME%/lib

# Java Bits.  On applicable platforms, tells the JVM to run in 32 or 64-bit mode.
wrapper.java.additional.auto_bits=TRUE

# Java Additional Parameters
wrapper.java.additional.1=-XX:+TieredCompilation
wrapper.java.additional.2=-Dprogram.name=standalone.bat
wrapper.java.additional.3=-XX:MaxPermSize=256M
wrapper.java.additional.4=-Dsun.rmi.dgc.client.gcInterval=3600000
wrapper.java.additional.5=-Dsun.rmi.dgc.server.gcInterval=3600000
wrapper.java.additional.6=-Djava.net.preferIPv4Stack=true
wrapper.java.additional.7=-Djboss.server.default.config=standalone.xml
wrapper.java.additional.8=-Dorg.jboss.resolver.warning=true
wrapper.java.additional.9=-Djboss.modules.system.pkgs=org.jboss.byteman
wrapper.java.additional.10=-Dorg.jboss.boot.log.file=%JBOSS_HOME%\standalone\log\boot.log
wrapper.java.additional.11=-Dlogging.configuration=file:%JBOSS_HOME%/standalone/configuration/logging.properties
wrapper.java.additional.12=-Dorg.tanukisoftware.wrapper.WrapperManager.mbean=false

# Initial Java Heap Size (in MB)
wrapper.java.initmemory=64

# Maximum Java Heap Size (in MB)
wrapper.java.maxmemory=512

# Application parameters.  Add parameters as needed starting from 1
wrapper.app.parameter.1=org.jboss.modules.Main
wrapper.app.parameter.2=-mp
wrapper.app.parameter.3=%JBOSS_HOME%\modules
wrapper.app.parameter.4=-jaxpmodule 
wrapper.app.parameter.5=javax.xml.jaxp-provider
wrapper.app.parameter.6=org.jboss.as.standalone
wrapper.app.parameter.7=-Djboss.home.dir=%JBOSS_HOME%