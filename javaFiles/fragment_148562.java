<target name="run" depends="compile">
    <java classname="com.mypackage.Main" fork="true">
        <classpath>
            <dirset dir="${other.dir}">
                <include name="out/**"/>
            </dirset>
            <pathelement location="${bin}" />
        </classpath>
    </java>
</target>