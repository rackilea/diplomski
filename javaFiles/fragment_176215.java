sourceSets {
    main {
        proto {
            srcDir 'src/main/proto'
        }
        java {
            // include self written and generated code
            srcDirs 'src/main/java', 'generated-sources/main/java'            
        }
    }
    // remove the test configuration - at least in your example you don't have a special test proto file
}

protobuf {
    // Configure the protoc executable
    protoc {
        // Download from repositories
        artifact = 'com.google.protobuf:protoc:3.0.0-alpha-3'
    }

    generateProtoTasks.generatedFilesBaseDir = 'generated-sources'

    generateProtoTasks {
        // all() returns the collection of all protoc tasks
        all().each { task ->
            // Here you can configure the task
        }

        // In addition to all(), you may get the task collection by various
        // criteria:

        // (Java only) returns tasks for a sourceSet
        ofSourceSet('main')

    }   
}