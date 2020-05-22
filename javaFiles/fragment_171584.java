task makeJar(type: Copy) {
    from('build/intermediates/packaged-classes/release/')
    into('release/')
    include('classes.jar')
    rename ('classes.jar', 'AndroidSensorPlugin.jar')
}