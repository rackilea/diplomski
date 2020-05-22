sourceSets {
    main {
        java {
            srcDir 'src/java'
            if ("true" == "$extraFeatures") {
                srcDir 'src/java/mysecretcode'
            }
        }
    }
}