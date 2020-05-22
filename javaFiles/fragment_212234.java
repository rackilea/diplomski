configurations {
    commonJars
}

dependencies {
    commonJars project( path: ':commonLibs' ) // might be needed to add 'configuration' as well
}

ospackage {
    from configurations.commonJars
    ..
}