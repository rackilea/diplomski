<target name="debug" depends="compile">
    <nbjpdastart addressproperty="jpda.address" name="MyProjectName" transport="dt_socket">
        <classpath>
            <pathelement location="${classes.dir}" />
            <path refid="libpath" />
        </classpath>
    </nbjpdastart>
    <java fork="true" classname="${main-class}">
        <sysproperty key="java.library.path" path="${dist.dir}" />
        <classpath>
            <pathelement location="${classes.dir}" />
            <path refid="libpath" />
        </classpath>
        <jvmarg value="-Xdebug" />
        <jvmarg value="-Xnoagent" />
        <jvmarg value="-Djava.compiler=none" />
        <jvmarg value="-Xrunjdwp:transport=dt_socket,address=${jpda.address}" />
    </java>
</target>