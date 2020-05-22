<target name="-post-test-run-with-groovy">
<junit dir="${work.dir}" errorproperty="tests.failed"
       failureproperty="tests.failed" fork="true"
       showoutput="true">
  <batchtest todir="${build.test.results.dir}">
    <fileset dir="${build.test.classes.dir}">
      <include name="**/*Test.class"/>
      <exclude name="**/*$*"/>
    </fileset>
  </batchtest>
  <classpath>
    <path path="${run.test.classpath}"/>
  </classpath>
  <syspropertyset>
  <propertyref prefix="test-sys-prop."/>
  <mapper from="test-sys-prop.*" to="*" type="glob"/>
  </syspropertyset>
  <formatter type="brief" usefile="false"/>
  <formatter type="xml"/>
  <jvmarg line="${run.jvmargs}"/>
</junit>

<mkdir dir="${build.test.results.dir}/../report"/>
<mkdir dir="${build.test.results.dir}/../report/html"/>

<junitreport todir="${build.test.results.dir}/../report">
  <fileset dir="${build.test.results.dir}">
    <include name="TEST-*.xml"/>
  </fileset>
  <report format="frames" todir="${build.test.results.dir}/../report/html"/>
</junitreport>