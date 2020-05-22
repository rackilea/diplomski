<target name = "JFXClean">
    <echo>Cleaning ${JFX.build.dir}...</echo>
    <delete dir = "${JFX.build.dir}"/>
    <delete dir = "${JFX.sign.dir}"/>
    <delete dir = "${store.dir}"/>
    <delete dir = "${sign.dir}"/>
</target>