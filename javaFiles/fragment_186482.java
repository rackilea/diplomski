<target name="war" description="--> Creates self-executing war">
  <property name="staging.dir" location="${basedir}/staging"/>
  <property name="webapp.dir" location="${basedir}/src/webapp"/>

  <mkdir dir="${staging.dir}"/>

  <!-- assumes you have all of your war content (excluding classes and libraries) already structured in a directory called src/webapp -->
  <!-- e.g. -->
  <!-- src/webapp/index.html -->
  <!-- src/webapp/WEB-INF/web.xml -->
  <!-- src/webapp/WEB-INF/classes/my.properties -->
  <!-- etc ... -->
  <copy todir="${staging.dir}">
    <fileset dir="${webapp.dir}" includes="**/*"/>
  </copy>

  <unjar dest="${staging.dir}">
    <!-- you'll have to locate these jars or appropriate versions; note that these include JSP support -->
    <!-- you might find some of them in the downloaded Jetty .tgz -->
    <fileset dir="path/to/jetty/jars">
      <include name="ant-1.6.5.jar"/>
      <include name="core-3.1.1.jar"/>
      <include name="jetty-6.1.24.jar"/>
      <include name="jsp-2.1-glassfish-2.1.v20091210.jar"/><!-- your JSP implementation may vary -->
      <include name="jsp-api-2.1-glassfish-2.1.v20091210.jar"/><!-- your JSP implementation may vary -->
      <include name="servlet-api-2.5-20081211.jar"/><!-- your Servlet API implementation may vary -->
    </fileset>
    <patternset><!-- to exclude some of the stuff we don't really need -->
      <exclude name="META-INF/**/*"/>
      <exclude name="images/**/*"/>
      <exclude name=".options"/>
      <exclude name="about.html"/>
      <exclude name="jdtCompilerAdapter.jar"/>
      <exclude name="plugin*"/>
    </patternset>
  </unjar>

  <!-- copy in the class file built from the above EmbeddedJettyServer.java -->
  <copy todir="${staging.dir}">
    <fileset dir="path/to/classes/dir" includes="com/mycompany/myapp/EmbeddedJettyServer.class"/>
  </copy>

  <war destfile="myapp.war" webxml="${webapp.dir}/WEB-INF/web.xml">
    <fileset dir="${staging.dir}" includes="**/*"/>
    <classes dir="path/to/classes/dir"/><!-- your application classes -->
    <lib dir="path/to/lib/dir"/><!-- application dependency jars -->
    <manifest>
      <!-- add the Main-Class attribute that will execute our server class -->
      <attribute name="Main-Class" value="com.mycompany.myapp.EmbeddedJettyServer"/>
    </manifest>
  </war>

  <delete dir="${staging.dir}"/>
</target>