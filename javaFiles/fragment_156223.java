gwt {
    gwtVersion='2.6.1' // Should match the gwt version used for building the gwt backend
    maxHeapSize="1G" // Default 256m is not enough for gwt compiler. GWT is HUNGRY
    minHeapSize="1G"

    src = files(file("src/")) // Needs to be in front of "modules" below.
    modules 'tech.otter.merchant.GdxDefinition'
    devModules 'tech.otter.merchant.GdxDefinitionSuperdev'
    project.webAppDirName = 'webapp'

    compiler {
        strict = true;
        enableClosureCompiler = true;//<------------------------REMOVE THIS
        disableCastChecking = true;
    }
}