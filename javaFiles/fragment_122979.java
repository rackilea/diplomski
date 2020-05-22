<target name="-post-jar">
    <jar destfile="dist/myjar.jar" update="true">
        <fileset dir="${basedir}">
            <include name="data/include/*"/>
        </fileset>
    </jar>
</target>