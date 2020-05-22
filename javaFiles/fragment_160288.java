<target name="init.deps" description="Download (if needed) and resolve the dependencies." unless="deps.init">

    <taskdef resource="org/apache/ivy/ant/antlib.xml" uri="antlib:org.apache.ivy.ant" classpath="${ivy.jar.file}" />

    <ivy:resolve />
    <ivy:cachepath pathid="ivy.path" conf="production" />

    <property name="deps.init" value="true"/> <!-- guard against multiple ivy computations -->

</target>