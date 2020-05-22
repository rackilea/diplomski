<target name = "JFXBuild" depends = "jar, JFXInit">
    <fx:jar destfile = "${JFX.build.dir}/${JFXProject.name}.jar">
        <fx:application name = "${JFXProject.name}"
                   mainClass = "${JFXMainClass}"/>
        <fileset dir = "build/classes"/>
    </fx:jar>
</target>