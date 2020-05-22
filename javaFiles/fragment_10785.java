<target name="compile">
    <delete dir="${dist.dir}/web/WEB-INF/classes" />
    <mkdir dir="${dist.dir}/web/WEB-INF/classes" />
    <javac destdir="${dist.dir}/web/WEB-INF/classes" srcdir="src">
        <classpath>
            <fileset dir="${basedir}/../web/WEB-INF/lib">
                  <include name="*" />
            </fileset>
        </classpath>
    </javac>
    <copy todir="${dist.dir}/web/WEB-INF/classes">
        <fileset dir="src">
            <include name="**/*.properties" />
            <include name="**/*.xml" />
        </fileset>
    </copy>
</target>