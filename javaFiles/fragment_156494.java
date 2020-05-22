task createTestForSource {
    inputs.dir 'src/main/java'
    outputs.dir 'src/test/java'

    doLast {
        fileTree('src/main/java').visit { FileVisitDetails fvd ->
            if (!fvd.directory) {
                String sourcePath = fvd.relativePath.asPath
                String testPath = sourcePath.replace('.java', 'Test.java')
                File testFile = file("src/test/java/$testPath")
                if (!testFile.exists()) {
                    testFile.parentFile.mkdirs()
                    testFile.text = // do your magic here
                }
            }
        }
    }
}