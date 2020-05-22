<junit fork="yes" printsummary="yes" haltonfailure="yes">
    <test name="${test.class.name}" todir="${test.reports}" />
    <formatter type="xml" />
    <classpath refid="test.classpath" />
    <sysproperty key="java.library.path" value="put your library path here"/>
</junit>