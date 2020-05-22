<!-- ============================================================== -->
<!-- Build application -->
<!-- ============================================================== -->
<target name="build" depends="make-bin-dir" description="Build application">
<javac srcdir="${src.dir}" destdir="${bin.dir}" debug="on" classpathref="javac.classpath" />
  <copy todir="${bin.dir}">
    <fileset dir="${src.dir}">
      <include name="**/*.xml" />
      <include name="**/*.jpg" />
      <include name="**/*.gif" />
      <include name="**/*.png" />
    </fileset>
  </copy>
</target>