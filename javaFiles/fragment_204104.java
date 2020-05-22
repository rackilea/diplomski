/**
 *  File: nonnull.gradle
 *
 *  Generates package-info.java for appropriate packages
 *  inside src/main/java folder.
 *
 *  This is a workaround to define @ParametersAreNonnullByDefault for all Java classes in a package
 *  i.e. including all subpackages (note: edit package name in line no. 19).
 */
task generateNonNullJavaFiles(dependsOn: "assembleDebug", type: Copy) {
    group = "Copying"
    description = "Generate package-info.java classes"

    def infoFileContentHeader = getFileContentHeader();
    def infoFileContentFooter = getFileContentFooter();

    def sourceDir = file( "${projectDir}" + File.separatorChar + "src" + File.separatorChar +
            "main" + File.separatorChar + "java" + File.separatorChar +
            "com" + File.separatorChar + "company" + File.separatorChar + "name" )
    sourceDir.eachDirRecurse { dir ->
        def infoFilePath = dir.getAbsolutePath() + File.separatorChar + "package-info.java"

        if (!file(infoFilePath).exists()) {
            def infoFileContentPackage = getFileContentPackage(dir.getAbsolutePath());
            new File(infoFilePath).write(infoFileContentHeader +
                    infoFileContentPackage + infoFileContentFooter)
            println "[dir] " + infoFilePath + "  created";
        }
    }
    println "[SUCCESS] NonNull generator: package-info.java files checked"
}

def getFileContentPackage(path) {
    def mainSrcPhrase = "src" + File.separatorChar + "main" + File.separatorChar +
            "java" + File.separatorChar
    def mainSrcPhraseIndex = path.indexOf(mainSrcPhrase)
    def output = path.substring(mainSrcPhraseIndex)

    // Win hotfix
    if (System.properties['os.name'].toLowerCase().contains('windows')) {
        output = output.replace("\\", "/")
        mainSrcPhrase = mainSrcPhrase.replace("\\", "/")
    }

    return "package " + output.replaceAll(mainSrcPhrase, "").replaceAll(
            "/", ".") + ";\n"
}

def getFileContentHeader() {
    return  "/** javadoc goes here \n */\n" +
            "@ParametersAreNonnullByDefault\n" +
            "@ReturnValuesAreNonnullByDefault\n"
}

def getFileContentFooter() {
    return  "\n" +
            "import javax.annotation.ParametersAreNonnullByDefault;\n" +
            "\n" +
            "import edu.umd.cs.findbugs.annotations.ReturnValuesAreNonnullByDefault;"
}