task generateFile(type: JavaExec) { ... }

task compileGeneratedFile(type: JavaCompile) { ... }

generateFile.mustRunAfter compileJava
generateFile.finalizedBy compileGeneratedFile
generateFile.onlyIf { !file("path/to/file").exists() }