<project name="applet" default="jar" basedir=".">

        <property name="jar.home" value="${basedir}/lib" />
        <property name="src.home" value="${basedir}/src-applet" />
        <property name="build.home" value="${basedir}/build-applet" />
        <property name="classes.home" value="${build.home}/classes" />
        <property name="jar.name" value="wami_audio_applet.jar" />
        <property name="jar.path" value="${jar.home}/jar.name" />

        <property name="compile.debug" value="true" />
        <property name="compile.deprecation" value="false" />
        <property name="compile.optimize" value="true" />

        <path id="compile.classpath">
                <pathelement location="${basedir}/lib" />
        </path>

        <target name="all" depends="clean, prepare, jar"/>

        <target name="clean">
                <delete dir="${jar.path}" />
                <delete dir="${classes.home}" />
        </target>

        <target name="prepare">
                <mkdir dir="${build.home}" />
                <mkdir dir="${jar.home}" />
                <mkdir dir="${classes.home}" />
        </target>

        <target name="compile" depends="prepare">
                <mkdir dir="${classes.home}" />
                <javac srcdir="${src.home}" destdir="${classes.home}" debug="${compile.debug}" deprecation="${compile.deprecation}" optimize="${compile.optimize}" target="1.5">
                        <classpath refid="compile.classpath" />
                </javac>
        </target>

        <target name="jar" depends="compile" description="Make the jar">
                <jar jarfile="${jar.home}/${jar.name}" basedir="${classes.home}">
                </jar>
        </target>
</project>