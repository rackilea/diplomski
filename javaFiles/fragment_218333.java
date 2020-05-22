<path id="lib.path">
  <fileset dir="${base.dir}" includes="HelloWord.jar"/>
</path>

<target name="runclasses" description="Use the Task">
    <taskdef name="helloworld" classname="HelloWorld" classpathref="lib.path" loaderref="lib.path.loader"/>
    <helloworld/>
    <taskdef name="helloworld1" classname="HelloWorld1" classpathref="lib.path" loaderref="lib.path.loader"/>
    <helloworld1/>
</target>