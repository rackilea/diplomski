jar {
    doLast {
        exec {
            executable "dx"
            args "--verbose", "--dex", "--output=../app/src/main/assets/mynewlib.dex", "build/libs/libmynewlib.jar"
        }
    }
}