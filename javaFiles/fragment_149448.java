compileJava {
    doFirst {
        options.compilerArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.controls,javafx.fxml'
        ]
    }
}

run {
    doFirst {
        jvmArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.controls,javafx.fxml'
        ]
    }
}