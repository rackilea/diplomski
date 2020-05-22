<target name="replaceTest" description="Set Test Server">
    <!-- Ensure GAE Test server is set -->
    <replace file="${basedir}/web/WEB-INF/appengine-web.xml" token="SERVER_NAME" value="testserver" />
    <replace file="${basedir}/web/WEB-INF/appengine-web.xml" token="deveserver" value="testserver" />
    <replace file="${basedir}/web/WEB-INF/appengine-web.xml" token="prodserver" value="testserver" />
</target>