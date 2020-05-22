<path id="master-classpath">
    <fileset dir="${lib.dir}">
        <include name="*.jar"/>
    </fileset>
</path>

<javac destdir="${classes.build.dir}">
    <src path="${src.dir}"/>
    <classpath refid="master-classpath"/>
</javac>