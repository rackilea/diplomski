<target name="jar" depends="compile">
<mkdir dir="${jar.dir}"/>

<jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}">
    <zipgroupfileset dir="${lib.dir}" includes="Logger.jar" />
    <manifest>
        <attribute name="Main-Class" value="${main-class}"/>
    </manifest>
</jar>
</target>