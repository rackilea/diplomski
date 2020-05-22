<target name="jar" depends="compile">
  <mkdir dir="${jar.dest}" />
  <jar
    manifest="manifest.txt"
    jarfile="${build.jar}"
    basedir="${build.dest}">
  </jar>
</target>