<project name="demo" default="build" xmlns:ivy="antlib:org.apache.ivy.ant">

    <target name="build">
        <ivy:retrieve pattern="${build.dir}/lib/[conf]/[artifact](-[classifier])-[revision].[ext]"/>

        <ivy:cachepath pathid="compile-classpath" conf="compile"/>
        <ivy:cachepath pathid="test-classpath" conf="test"/>
    </target>

</project>