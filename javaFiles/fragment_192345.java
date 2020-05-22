android {
    ...
}

android.applicationVariants.all {
    def aptOutputDir = new File(buildDir, "generated/source/apt/${it.unitTestVariant.dirName}")
    it.unitTestVariant.addJavaSourceFoldersToModel(aptOutputDir)
}