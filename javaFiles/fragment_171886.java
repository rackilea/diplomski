task jlink(type: Exec) {
    dependsOn 'clean'
    dependsOn 'jar'
    dependsOn 'libs'
    ...
}