<target name="deploy">
    <path id="wl.deploy.path">
        <fileset file="${env.WL_HOME}\server\lib\weblogic.jar" />
        <fileset file="${env.WL_HOME}\server\lib\webservices.jar" />
    </path>
    <taskdef name="wldeploy" classname="weblogic.ant.taskdefs.management.WLDeploy">
        <classpath refid="wl.deploy.path" />
    </taskdef>
    <wldeploy
        action="deploy" verbose="false" debug="false"
        name="${ear.name}" source="${deploy.dir}/goip.ear"
        user="weblogic" password="weblogic"
        adminurl="t3://localhost:7001" targets="GO_Cluster1">
    </wldeploy>
</target>