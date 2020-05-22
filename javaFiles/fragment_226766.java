jar {
    dependsOn 'cleanAfterProguard'
    manifest {
        attributes(
                'Main-Class': 'org.openjfx.Launcher'
        )
    }
    from zipTree("${buildDir}/proguard/output.jar")
}