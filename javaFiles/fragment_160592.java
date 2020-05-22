<target name="compile">
    <javac  srcdir="src" destdir="${dir.class}/${app.name}" debug="true" debuglevel="lines,vars,source" >
        <classpath>
            <pathelement location="..." />
        </classpath>
    </javac>
</target>

<target name="debug" description="Debug the Application" depends="compile">
    <java jar="${dir.binary}/${app.name}-${app.version}.jar" fork="true">
        <jvmarg value="-Xdebug" />
        <jvmarg value="-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5555" />
    </java>
</target>