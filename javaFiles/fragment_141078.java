<project name="demo" default="build">

   <target name="bootstrap">
      <mkdir dir="${user.home}/.ant/lib"/>
      <get dest="${user.home}/.ant/lib/commons-net.jar" src="http://search.maven.org/remotecontent?filepath=commons-net/commons-net/3.3/commons-net-3.3.jar"/>
      <get dest="${user.home}/.ant/lib/oro.jar" src="http://search.maven.org/remotecontent?filepath=oro/oro/2.0.8/oro-2.0.8.jar"/>
   </target>

   <target name="build">
      <ftp server="ftp.apache.org" userid="anonymous" password="me@myorg.com">
         <fileset dir="htdocs/manual"/>
      </ftp>
   </target>

</project>