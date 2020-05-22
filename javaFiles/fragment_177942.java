<target name="unit-test-1" >
  <junit printsummary="yes" haltonfailure="yes">
    <classpath>
      <pathelement location="${project.class.path}"/>
      <pathelement location="${build.tests}"/>
      <pathelement path="${java.class.path}"/>
    </classpath>
    <test name="com.jenkov.test.MyUnitTest"
             haltonfailure="no" outfile="result">
      <formatter type="plain"/>
      <formatter type="xml"/>
    </test>
  </junit>
</target>