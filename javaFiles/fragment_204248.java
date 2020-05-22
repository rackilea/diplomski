configurations {
    checker
}

dependencies {
    checker "org.checkerframework:checker:1.9.6"
    checker 'org.checkerframework:jdk8:1.9.6'
    compile configurations.checker.dependencies
}

allprojects {
    tasks.withType(JavaCompile).all { JavaCompile compile ->
        compile.options.debug = true
        compile.options.compilerArgs = [
                "-Xbootclasspath/p:${configurations.checker.asPath}",
                '-processor', 'org.checkerframework.checker.nullness.NullnessChecker',
                '-implicit:class',
                '-AprintErrorStack'
        ]
    }
}