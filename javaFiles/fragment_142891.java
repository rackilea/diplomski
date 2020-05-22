task dumpClasses {
    inputs.files configurations.compile
    outputs.file "$buildDir/dumpClasses.txt"
    doLast {
        file("$buildDir/dumpClasses.txt").withWriter { writer ->
            configurations.compile.each { file ->
                FileTree tree = file.name.endsWith('.jar')
                   ? zipTree(file)
                   : (file.directory ? fileTree(file) : null)
                if (tree) {
                    tree.matching { include '**/*.class' }.each {
                        writer.println(it.name)
                    }
                } 
            }
        } 
    } 
}