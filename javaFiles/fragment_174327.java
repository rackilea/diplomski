<target name="compile-widgetset" depends="init,resolve">
    <delete includeEmptyDirs="true">
        <fileset dir="${basedir}/WebContent/VAADIN/gwt-unitCache/" includes="**/*" defaultexcludes="no"/>
    </delete>
    <java classname="com.vaadin.tools.WidgetsetCompiler" failonerror="yes" fork="yes" maxmemory="600m">     
        <jvmarg value="-Xms512M"/>
        <jvmarg value="-Xmx1024M"/>
        <jvmarg value="-Xss8M"/>
        <jvmarg value="-Djava.awt.headless=true" />
        <arg value="-war"/>
        <arg value="WebContent/VAADIN/widgetsets"/>
        <arg value="${widgetset}"/>
        <arg value="-logLevel"/>
        <arg value="DEBUG"/>
        <arg value="-style"/>
        <arg value="OBF"/>

        <classpath>         
            <pathelement path="${module.src.dir}"/>
            <pathelement path="${module.build.dir}/WebContent/WEB-INF/classes" />
            <pathelement path="${module.build.dir}/WebContent/WEB-INF/lib" />
            <path refid="widgetset.path"/>
        </classpath>
    </java>
</target>