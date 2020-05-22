<target name="jar" depends="compile">
    <mkdir dir="${jar.dir}"/>
    <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}">
        <zipgroupfileset dir="${lib.dir}" includes="**/*.jar"/>
        <manifest>
            <attribute name="Main-Class" value="${main-class}"/>
            <attribute name="Class-Path" value="config/ properties/ ${manifest.classpath}" />
        </manifest>
    </jar>
</target>

<target name="run" depends="jar">
    <java fork="true" jar="${jar.dir}/${ant.project.name}.jar" />
</target>