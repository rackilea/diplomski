task resolveCompileDependency(type: Copy) {
    //download libraries specified in dependency configuration
    def lib_files = configurations.myCompile.resolve()
    //print names of downloaded files and copy to build directory (optional)
    lib_files.each {File file ->
        println file.name
    }
    from lib_files
    into 'build/classes'
    outputs.files(lib_files)
}