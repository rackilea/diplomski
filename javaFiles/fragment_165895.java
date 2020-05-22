// option 1
tasks {
    getByName<BootJar>("bootJar") {
        classifier = "boot"
        mainClassName = "com.example.Application"
    }
}

// option 2
tasks.getByName<BootJar>("bootJar") {
    classifier = "boot"
    mainClassName = "com.example.Application"
}