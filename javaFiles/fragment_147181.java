run {
    doFirst {
        jvmArgs = ['--module-path', classpath.asPath,
                   '--add-modules', 'javafx.controls']
    }
}