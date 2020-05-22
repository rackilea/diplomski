jar {
    manifest {
        // required attribute "Main-Class"
        attributes "Main-Class": "com.mrhacki.myApp.Loading"
    }

    // collect (and unzip) dependencies into the fat jar
    from {
        configurations.compile.collect { 
            it.isDirectory() ? it : zipTree(it) 
        }
    }
}