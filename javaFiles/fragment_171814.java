<target name="run" depends="jar">
    <mkdir dir="${output.dir}" />
    <apply executable="java">
         <fileset dir="${test.dir}" />
         <arg value="-jar"/>
         <arg path="${jar.dir}/${myjar}.jar" />
         <srcfile />
         <redirector>
              <outputmapper id="out" type="glob" from="*" to="${output.dir}/*" />
         </redirector>
    </apply>
</target>