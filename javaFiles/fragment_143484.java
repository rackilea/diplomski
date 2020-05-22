class SqljTask extends DefaultTask {
    @Input
    String encoding
    @Input
    List<String> additionalArgs = []
    @InputDirectory
    File sqljDir
    @OutputDirectory
    File generatedJava
    @OutputDirectory
    File generatedResources

    @TaskAction
    void generate() {

        project.mkdir generatedJava
        project.mkdir generatedResources

        project.fileTree(sqljDir).visit { FileVisitDetails fvd ->
           if (!fvd.directory) {
               List<String> sqljArgs = []
               sqljArgs << "-dir=$generatedJava"
               sqljArgs << "-d=$generatedResources"
               sqljArgs << "-encoding=$encoding"
               sqljArgs << "-compile=false"
               sqljArgs << fvd.file.absolutePath
               sqljArgs.addAll(additionalArgs)
               int result = sqlj.tools.Sql.statusMain(sqljArgs as String[])
               if (result != 0) throw new RuntimeException("Can't translate $fvd.file ($returnCode)"   
           }            
        }
    }
}