<ear destfile="${ear.file}" appxml="META-INF/application.xml">
    <zipfileset dir="lib" prefix="lib"/>

    <fileset dir="${temp.dir}">
        <include name="*.war" />
    </fileset>
</ear>