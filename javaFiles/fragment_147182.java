task runExercise1(type: JavaExec) {
    classpath = sourceSets.main.runtimeClasspath
    jvmArgs = ['--module-path', classpath.asPath, 
               '--add-modules', 'javafx.controls' ]
    main = 'exercise1.Cards'
}