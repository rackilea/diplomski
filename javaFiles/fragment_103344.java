<target name="-post-jar">
  <jar update="true" destfile="${dist.jar}">
    <!-- Path to your jar. -->
    <zipfileset src="/home/user/javalibs/myjar.jar"/>
 </jar>
</target>