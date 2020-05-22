configurations {
    testUtils
}

task testUtilsJar(type: Jar) {
    ...
}

artifacts {
    testUtils testUtilsJar
}