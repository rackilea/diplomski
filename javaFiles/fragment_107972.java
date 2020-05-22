<target name="compile" depends="prepare-src">
    <javac srcdir="${build.src}"
       destdir="${build.dest}"
       debug="${debug}"
       optimize="${optimize}"
       target="1.3"
       source="1.3"
       deprecation="${deprecation}"
       classpathref="compile.classpath">
    <compilerarg value="-Djava.endorsed.dirs=/some/path/lib/endorsed"/>
</javac>