compileJava {
    options.compilerArgs << "-s"
    options.compilerArgs << "$projectDir/generated/java"

    doFirst {
        // make sure that directory exists
        file(new File(projectDir, "/generated/java")).mkdirs()
    }
}

clean.doLast {
    // clean-up directory when necessary
    file(new File(projectDir, "/generated")).deleteDir()
}

sourceSets {
    generated {
        java {
            srcDir "$projectDir/generated/java"
        }
    }
}