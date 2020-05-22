<java classname="${main-class}" fork="true" >
  <classpath>
    <path refid="classpath"/>
    <pathelement location="${jar.dir}/${ant.project.name}.jar"/>
  </classpath>
</classpath> </java>