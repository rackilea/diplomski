<target name="copy-resources">
    <copy todir="${targetdir}">
        <fileset dir="${sourcedir}">
            <exclude name="**/*.java"/>
        </fileset>
    </copy>
</target>