<target name="dist" description="Unpack the file to war file" depends="compile">
   <war basedir="${dir.webRoot}" warfile="${webapp.deployPath}/${project.distname}.war"
                                     webxml="${dir.webRoot}/WEB-INF/web.xml">
    <exclude name="WEB-INF/web.xml"/>
    <exclude name="WEB-INF/lib/junit-4.6.jar"/>
   </war>
</target>