<Host name="localhost"  appBase="webapps"
        unpackWARs="true" autoDeploy="true">

    <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
           prefix="localhost_access_log." suffix=".txt"
           pattern="%h %l %u %t &quot;%r&quot; %s %b" />
<Context docBase="yourApp" path="/" reloadable="true" />
</Host>