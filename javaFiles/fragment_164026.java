task generateClass(type: org.springframework.boot.gradle.tasks.run.BootRun, dependsOn: 'build') {
        doFirst() {
            main = 'com.etcbase.uyap.generator.GeneratorApplication'
            classpath = sourceSets.main.runtimeClasspath
            args '--class'
            systemProperty 'spring.profiles.active', 'dev'
        }
    }

    task generateMetadata(type: org.springframework.boot.gradle.tasks.run.BootRun, dependsOn: 'build') {
        doFirst() {
            main = 'com.etcbase.uyap.generator.GeneratorApplication'
            args '--metadata'
            classpath = sourceSets.main.runtimeClasspath
            systemProperty 'spring.profiles.active', 'test'
        }
    }