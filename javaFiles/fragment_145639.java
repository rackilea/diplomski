<target name="unjar.jar">
        <unjar dest="${temp.dir}">
              <patternset>
                    <include name="**/*.class" />
              </patternset>
              <fileset dir="${lib.dir}">
                    <include name="**/*.jar" />
              </fileset>
        </unjar>
  </target>


  <target name="combine.jar" depends="unjar.jar">
        <jar jarfile="${base.dir}/${jar.filename}"
              basedir="${temp.dir}" includes="**/*.class" update="true"
              compress="false">
        </jar>
        <delete dir="${temp.dir}" quiet="true" />
  </target>