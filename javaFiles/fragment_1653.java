<target name="copy-all-unzipped">
    <for param="file">
        <path>
            <fileset dir="${path.unzipped}">
                <include name="**/content.xml"/>
            </fileset>
        </path>
        <sequential>
            <copy-unzipped file-path="@{file}"/>
        </sequential>
    </for>
</target>

<macrodef name="copy-unzipped">
    <attribute name="file-path"/>
    <sequential>
        <echo>@{file-path}</echo>
    </sequential>
</macrodef>