<target name="buildwar">
    <war basedir="${basedir}/dist/web" destfile="My.war"
     webxml="${basedir}/dist/web/WEB-INF/web.xml">
        <exclude name="WEB-INF/**" />
        <webinf dir="${basedir}/dist/web/WEB-INF/">
            <include name="**/*.jar" />
        </webinf>
    </war>
</target>