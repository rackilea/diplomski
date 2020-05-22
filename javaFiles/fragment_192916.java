apply plugin: "idea"

sourceSets.main.java.srcDir new File(buildDir, '${buildDir}/generated-src/')
idea {
    module {
        // Marks the already(!) added srcDir as "generated"
        generatedSourceDirs += file('${buildDir}/generated-src/')
    }
}