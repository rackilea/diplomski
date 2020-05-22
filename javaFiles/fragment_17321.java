<project>
 ...

<build>
<outputDirectory>${basedir}/${target.dir}/classes</outputDirectory>
<testOutputDirectory>${basedir}/${target.dir}/test-
classes</testOutputDirectory>
</build>

<properties>
<target.dir>target</target.dir>
</properties>

<profiles>
<profile>
  <id>eclipse-folders</id>
  <properties>
    <target.dir>target-eclipse</target.dir>
  </properties>
 </profile>
  </profiles>