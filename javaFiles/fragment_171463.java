task ciBuild {
    def cobolFiles = fileTree("src/main/cobol").matching {
        include "**/*.CBL"
    }
    dependsOn collectFiles
    inputs.files cobolFiles
    outputs.dir 'path/to/outputDir'
    doLast {
        cobolFiles.files.parallelStream().each { File file ->
            exec {
                commandLine "${projectDir}/compileFile.bat"
                args file.absolutePath
                ignoreExitValue = true
            }
        }
    }
}