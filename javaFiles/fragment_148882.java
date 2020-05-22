<target name="junit" description="Runs the unit tests" depends="jar">
    <delete dir="${junit.out.dir.xml}"/>
    <mkdir  dir="${junit.out.dir.xml}"/>
    <junit printsummary="yes" haltonfailure="no">
        <classpath refid="classpath.test"/>
        <formatter type="xml"/>
        <batchtest fork="yes" todir="${junit.out.dir.xml}">
            <fileset dir="${src.dir}" includes="**/*Test.java"/>
        </batchtest>
    </junit>
</target>

<target name="junitreport" description="Create a report for the rest result">
    <mkdir dir="${junit.out.dir.html}"/>
    <junitreport todir="${junit.out.dir.html}">
        <fileset dir="${junit.out.dir.xml}">
            <include name="*.xml"/>
        </fileset>
        <report format="frames" todir="${junit.out.dir.html}"/>
    </junitreport>
</target>