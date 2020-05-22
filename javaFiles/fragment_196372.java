task copyResources(type: Copy) {
    from "${projectDir}/src/main/resources"
    into "${buildDir}/classes/main"
}

processResources.dependsOn copyResources