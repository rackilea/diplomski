<path id="cobertura.class.path">
    <pathelement location="${common.dir}/../tools/cobertura/cobertura.jar" />
    <pathelement location="${common.dir}/../tools/cobertura/lib/asm-3.0.jar" />
    <pathelement location="${common.dir}/../tools/cobertura/lib/asm-tree-3.0.jar" />
    <pathelement location="${common.dir}/../tools/cobertura/lib/log4j-1.2.9.jar" />
    <pathelement location="${common.dir}/../tools/cobertura/lib/jakarta-oro-2.0.8.jar" />
</path>

<taskdef classpathref="cobertura.class.path" resource="tasks.properties" />