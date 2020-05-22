task integTest2(type: Test) {
    useTestNG()
    testClassesDir  = project.sourceSets.special.output.classesDir
    classpath = classpath.plus(files(testClassesDir))
    testSrcDirs    += project.sourceSets.special.java.srcDirs.toList()
}