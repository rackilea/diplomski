task downloadtheArtifacts {
    doLast {
        exec {
            commandLine './script1.sh'
        }
        exec {
            commandLine './script2.sh'
        }
    }
}