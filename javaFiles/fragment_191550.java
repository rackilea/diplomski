<target name="compile">
<mkdir dir="${classes.dir}"/>
<javac includeantruntime="false" srcdir="${src.dir}" destdir="${classes.dir}">
    <classpath>
        <pathelement path="${lib.dir}/Logger.jar"/>
    </classpath>
</javac>
<copy todir="${classes.dir}">
  <fileset dir="${src.dir}" excludes="**/*.java"/>
</copy>
</target>