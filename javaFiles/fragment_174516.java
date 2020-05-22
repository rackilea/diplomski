<target name="run" depends="jar">

    <java jar="${jar.dir}/${ant.project.name}.jar" fork="true">
        <arg value="${arg1}"/>
        <arg value="${arg2}"/>
        <arg value="${arg3}"/>
        <arg value="${arg4}"/>
        <arg value="${arg5}"/>
    </java>
</target>