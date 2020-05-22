plugins {
    scala
}

dependencies {
    compile(project(":core"))
    compile(Conf.plugins.ammonite)
}

tasks{
    "printClasspath"{
        dependsOn("assemble")
        doLast{
            println(java.sourceSets["main"].runtimeClasspath.asPath)

        }
    }
}