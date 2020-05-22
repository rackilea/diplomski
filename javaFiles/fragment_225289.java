// ear
into('/') {
    from myFiles
}
// classpath
files(configurations.deploy, configurations.earlib, myFiles)