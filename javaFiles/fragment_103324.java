<target name="run" depends="jar">
    <java jar="${jar.dir}/${ant.project.name}.jar" fork="true">
        <arg value="${file1}"/>
        <arg value="${file2}"/>
    </java>
</target>