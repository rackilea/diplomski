//Get LUAJ
buildscript { dependencies { classpath 'de.undercouch:gradle-download-task:3.1.1' }}
apply plugin: 'de.undercouch.download'
task GetLuaJ {
    //Configure
    def JARDownloadURL='http://central.maven.org/maven2/org/luaj/luaj-jse/3.0.1/luaj-jse-3.0.1.jar' //compile 'org.luaj:luaj-jse:3.0.1'
    def BaseDir="$projectDir/luaj"
    def ExtractToDir='class'
    def ConfirmAlreadyDownloadedFile="$BaseDir/$ExtractToDir/lua.class"
    def JarFileName=JARDownloadURL.substring(JARDownloadURL.lastIndexOf('/')+1)
    def ClassesToDeleteDir="$BaseDir/$ExtractToDir/org/luaj/vm2/lib/jse"
    def ClassNamesToDelete=["JavaMethod", "LuajavaLib"]

    //Only run if LuaJ does not already exist
    if (!file(ConfirmAlreadyDownloadedFile).exists()) {
        //Download and extract the source files to /luaj
        println 'Setting up LuaJ' //TODO: For some reason, print statements are not working when the "copy" directive is included below
        mkdir BaseDir
        download {
            src JARDownloadURL
            dest BaseDir
        }
        copy {
            from(zipTree("$BaseDir/$JarFileName"))
            into("$BaseDir/$ExtractToDir")
        }

        //Remove the unneeded class files
        ClassNamesToDelete=ClassNamesToDelete.join("|")
        file(ClassesToDeleteDir).listFiles().each {
            if(it.getPath().replace('\\', '/').matches('^.*?/(?:'+ClassNamesToDelete+')[^/]*\\.class$')) {
                println "Deleting: $it"
                it.delete()
            }
        }
    }
}