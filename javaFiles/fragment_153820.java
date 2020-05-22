<project name="demo" default="resolve" xmlns:ivy="antlib:org.apache.ivy.ant">

    <target name="bootstrap" description="Install ivy">
        <mkdir dir="${user.home}/.ant/lib"/>
        <get dest="${user.home}/.ant/lib/ivy.jar" src="http://search.maven.org/remotecontent?filepath=org/apache/ivy/ivy/2.3.0/ivy-2.3.0.jar"/>
    </target>

    <target name="resolve" description="Use ivy to resolve classpaths">
        <ivy:resolve/>

        <ivy:report todir='build/ivy-reports' graph='false' xml='false'/>

        <ivy:cachepath pathid="compile.path" conf="compile"/>
        <ivy:cachepath pathid="test.path"    conf="test"/>
    </target>

    <target name="clean" description="Cleanup build files">
        <delete dir="build"/>
    </target>

    <target name="clean-all" depends="clean" description="Additionally purge ivy cache">
        <ivy:cleancache/>
    </target>

</project>