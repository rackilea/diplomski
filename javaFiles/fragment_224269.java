task preprocessVersionInfo(type:Copy){
    include "VersionInfo.java"
    from "src/main/java"
    into "$buildDir/preprocessedJava"

    inputs.property "version", project.version

    filter(org.apache.tools.ant.filters.ReplaceTokens, tokens: [version: project.version])
}

compileJava {
    source preprocessVersionInfo.outputs.files
    exclude {
        it.file.absolutePath.endsWith("src/main/java/VersionInfo.java")
    }
}