import javax.servlet.http.HttpServletRequest;

this is the error im getting now [QUOTE]13-Sep-2010 12:22:45 org.apache.catalina.startup.HostConfig deployWAR
INFO: Deploying web application archive ZangV3Spring.war
13-Sep-2010 12:22:49 org.apache.catalina.core.StandardContext startInternal
SEVERE: Error listenerStart
13-Sep-2010 12:22:49 org.apache.catalina.core.StandardContext startInternal
SEVERE: Context [/ZangV3Spring] startup failed due to previous errors
13-Sep-2010 12:22:49 org.apache.catalina.loader.WebappClassLoader clearReferencesJdbc
SEVERE: The web application [/ZangV3Spring] registered the JBDC driver [com.mysql.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
13-Sep-2010 12:22:59 org.apache.catalina.startup.HostConfig checkResources
INFO: Undeploying context [/ZangV3Spring]
13-Sep-2010 12:22:59 org.apache.catalina.startup.HostConfig deployWAR
INFO: Deploying web application archive ZangV3Spring.war
13-Sep-2010 12:23:03 org.apache.catalina.core.StandardContext startInternal
SEVERE: Error listenerStart
13-Sep-2010 12:23:03 org.apache.catalina.core.StandardContext startInternal
SEVERE: Context [/ZangV3Spring] startup failed due to previous errors