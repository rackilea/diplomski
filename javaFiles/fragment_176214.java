// ...

protobuf {
// Configure the protoc executable
protoc {
    // Download from repositories
    artifact = 'com.google.protobuf:protoc:3.0.0-alpha-3'
}

generateProtoTasks.generatedFilesBaseDir = 'src' // <- that line 

generateProtoTasks {
    // all() returns the collection of all protoc tasks
    all().each { task ->
        // Here you can configure the task
    }