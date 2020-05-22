apply plugin: 'base'

task tarContents(type: Tar) {
    from 'contents'
    archiveName = "${project.name}.tar"
    destinationDir file('build/tar')
}

artifacts {
    archives file: tarContents.archivePath, type: 'tar', builtBy: tarContents
}