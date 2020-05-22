<target name="run" depends="compile">
    <java classname="VanillaDataReaderClient">
        <classpath>
            <pathelement location="${obj}"/>
            <path refid="dependency.classpath"/>
        </classpath>
    </java>
</target>