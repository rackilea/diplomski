jar {
archiveName = 'Name.jar'

manifest {
    attributes 'Main-Class': 'Main',
            'Class-Path': configurations.runtime.files.collect { "lib/$it.name" }.join(' '),
            'Implementation-Version': project.version (if any)
}

from(configurations.compile.collect { it.isDirectory() ? it : zipTree(it) })
}