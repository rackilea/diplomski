<target name="getPrependJars">
    <fileset id="appendJars" dir="${project.name}/hotfixes">
        <include name="*.jar" />
    </fileset>
    <pathconvert property="prependJars" refid="appendJars" pathsep="," />

    <echo message="prependJars: ${prependJars}" />
</target>