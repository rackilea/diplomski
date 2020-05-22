<java classname="org.apache.tools.ant.launch.Launcher" fork="true" failonerror="true">
        <sysproperty key="weblogic.home" value="${weblogic.home}"/>
        <sysproperty key="osb.home" value="${osb.home}"/>
         <arg value="test"/>
</java>
<target name="test">
<configjar debug="${task.debug}"
               failonerror="${task.failonerror}"
               errorProperty="${task.errorproperty}"
               settingsFile="${settingsFile}" >
    </configjar>
</target>