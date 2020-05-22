idea.module {
    val testSources = testSourceDirs

    testSources.addAll(project.sourceSets.getByName("systemTest").java.srcDirs)
    testSources.addAll(project.sourceSets.getByName("systemTest").resources.srcDirs)

    testSourceDirs = testSources
}