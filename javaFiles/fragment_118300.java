<!-- compile-build is previous target. current build is depend on it. After compilation this build executed -->
<!-- directory-attrib is attribule to where you save your jar -->
<!-- bin.dir is you compiled class file, generally it is bin directory -->
<!-- version-num is version num specified by you -->
<property name="bin.dir" value="${basedir}/bin" />
<target name="build" depends="compile-build"
    description="build and pack Jar API classes">
    <jar destfile="${directory-attrib}/ur-jar-name.jar" basedir="${bin.dir}">
        <manifest>
            <attribute name="Built-By" value="${user.name}" />
            <section name="Build-Info">
                <attribute name="Version" value="${version-num}" />
            </section>
        </manifest>
    </jar>
</target>