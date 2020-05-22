<project name="demo" default="copy">

  <target name="bootstrap">
    <mkdir dir="${user.home}/.ant/lib"/>
    <get dest="${user.home}/.ant/lib/groovy-all.jar" src="http://search.maven.org/remotecontent?filepath=org/codehaus/groovy/groovy-all/2.2.1/groovy-all-2.2.1.jar"/>
  </target>

  <target name="copy">
    <taskdef name="groovy" classname="org.codehaus.groovy.ant.Groovy"/>
    <groovy>
    new File("build.txt").eachLine {
      ant.copy(file:it, todir:"target", verbose:true)
    }
    </groovy>
  </target>

</project>