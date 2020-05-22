apply plugin: 'war'

war.dependsOn(':A:war')

war {
    from project(':A').sourceSets.main.output.classesDir
}