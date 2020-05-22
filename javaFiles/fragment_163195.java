<java failonerror="true" fork="true" classname="com.google.gwt.dev.Compiler">
    <classpath>
        <pathelement location="${src.dir}"/>
        <pathelement location="${build.dir}"/>
        <path refid="project.classpath"/>
    </classpath>
    <jvmarg value="-Xmx256M"/>
    <arg value="-sourceLevel"/><arg value="7"/>
    <arg value="${gwt.module.name}"/>
</java>