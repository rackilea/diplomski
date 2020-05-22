<target name="test" depends="test-compile">
    <junit>
        <batchtest todir="${test.build.dir}" unless="testcase">
            <fileset dir="${test.build.classes}"
                includes = "**/Test*.class"
                excludes = "**/*$*.class"/>
        </batchtest>
    </junit>
</target>