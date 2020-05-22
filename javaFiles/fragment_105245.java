<!-- Put everything in ${build} into the <Project>.jar file -->
    <jar jarfile="${dist}/${ant.project.name}.jar" basedir="${build}"/>

    <!-- Copy MY program into lib to get packed by exe4jc -->
    <copy file="${dist}/${ant.project.name}.jar" todir="${lib}"/>

    <!-- Create an exe -->
    <apply executable="c:\Program Files\exe4j\bin\exe4jc.exe" failonerror="true">
      <fileset dir="${lib}">
        <patternset>
          <include name="${ant.project.name}.exe4j"/>
        </patternset>
      </fileset>
    </apply>