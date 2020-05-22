<target name="junit" depends="compile-tests" description="Runs JUnit tests">
    <mkdir dir="${junit.report}"/>
    <junit printsummary="true" failureProperty="test.failed">
        <classpath refid="test.classpath"/>
        <formatter type="xml"/>
        <test name="${test.class}" todir="${junit.report}" if="test.class"/>
        <batchtest fork="true" todir="${junit.report}" unless="test.class">
            <fileset dir="${test.src.dir}">
                <include name="**/*Test.java"/>
                <exclude name="**/AllTests.java"/>
            </fileset>
        </batchtest>
    </junit>
</target>