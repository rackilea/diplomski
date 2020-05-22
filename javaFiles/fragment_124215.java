<target name="generate.coverage" depends="buckminster.init">
  <!-- Generate the classpath. -->
  <path id="cobertura.classpath">
    <fileset dir="${tasks.dir}/lib/cobertura">
      <include name="cobertura.jar" />
      <include name="**/*.jar" />
    </fileset>
  </path>
  <taskdef classpathref="cobertura.classpath" resource="tasks.properties" />

  <!-- Get ready to run the unit tests app, and delete old coverage data. -->
  <unzip src="${test-app.artifact}" dest="${output.dir}" overwrite="true" />
  <delete file="${output.dir}/cobertura.ser" />

  <!-- Instrument the jars in-place. Make sure to only capture what you want instrumented! -->
  <cobertura-instrument datafile="${output.dir}/cobertura.ser">
    <fileset dir="${output.dir}/test-app/plugins">
      <include name="**/*our.company_*.jar" />
    </fileset>
  </cobertura-instrument>

  <!-- Run the unit test application, by classname rather than by jar. -->
  <java fork="true" classname="org.eclipse.equinox.launcher.Main" logerror="true" failonerror="true" maxmemory="1G">
    <classpath>
      <pathelement location="${output.dir}/test-app/startup.jar" />
      <pathelement location="${tasks.dir}/lib/cobertura/cobertura.jar" />
      <fileset dir="${tasks.dir}/lib/cobertura">
        <include name="**/*.jar" />
      </fileset>
      <pathelement location="${java.class.path}" />
    </classpath>
    <sysproperty key="net.sourceforge.cobertura.datafile" file="${output.dir}/cobertura.ser" />            
    <arg value="-data" />
    <arg value="${output.dir}/test-app/workspace" />
    <arg value="--formatter=org.apache.tools.ant.taskdefs.optional.junit.XMLJUnitResultFormatter:${log.dir}/test-results.xml" />
  </java>

  <!-- Generate the coverage reports. -->
  <cobertura-report format="html" datafile="${output.dir}/cobertura.ser" destdir="${output.dir}/cobertura-report">
    <fileset dir="${workspace.dir}/plugins">
      <include name="**/*.java" />
    </fileset>
  </cobertura-report>
</target>