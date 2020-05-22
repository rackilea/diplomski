<target name="build" depends="compile">
    <ivy:retrieve pattern="${dist.dir}/lib/[artifact].[ext]"/>

    <manifestclasspath property="jar.classpath" jarfile="${dist.jar}">
      <classpath>
        <fileset dir="${dist.dir}/lib" includes="*.jar"/>
      </classpath>
    </manifestclasspath>

    <jar destfile="${dist.jar}" basedir="${build.dir}/classes">
      <manifest>
        <attribute name="Main-Class" value="${dist.main.class}"/>
        <attribute name="Class-Path" value="${jar.classpath}"/>
      </manifest>
    </jar>
  </target>