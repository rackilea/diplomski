project.ext.set('nativeLibsDir', "$buildDir/libs/natives")

configurations {
    nativeBundle
}

dependencies {
    nativeBundle 'sigar:sigar:1.6.4:native'
}

task extractNativeBundle(type: Sync) {
    from {
        configurations.nativeBundle.collect { zipTree(it) }
    }
    into file(project.nativeLibsDir)
}

dist.dependsOn extractNativeBundle