<target name="run.junit" depends="clean.junit, junit.info, prepare.junit"
    description="Compiles and runs all JUnit Tests in the 'test' directory and produces a report of all failures">

<junit printsummary="yes" fork="true" haltonfailure="no" showoutput="yes" maxmemory="512m">
      <jvmarg line="${junit.jvm.arg}"/>
      <classpath>
        <fileset dir="${src.dir}">
          <include name="**/*.*"/>
        </fileset>
        <fileset dir="${ear.dist.dir}/build/classes">
          <include name="**/*.*"/>
        </fileset>
         <pathelement path="${test.run.path}"/>
      </classpath>
      <formatter type="xml"/>
      <batchtest fork="true" todir="${ear.dist.dir}/build/junit">
      <fileset dir="${test.src.dir}" includes="${test.pattern.include}"/>
      </batchtest>
    </junit>

</target>