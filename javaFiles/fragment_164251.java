<junit printsummary="yes" haltonfailure="yes">
    <classpath>
      <dirset dir="${user.home}/.ivy2/cache">
        <include name="**" />
      </dirset>
      <path refid="ivy.classpath"/>  <!-- ivy.classpath is already a path -->
      <pathelement location="${dir.classes}"/>
      <pathelement location="${dir.classes.tests}"/>
    </classpath>

    <batchtest fork="yes">
      <fileset dir="junit">
        <include name="**/*Test.java"/>
      </fileset>
    </batchtest>
</junit>