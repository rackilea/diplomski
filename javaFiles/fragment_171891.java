plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.5'
    id 'org.beryx.jlink' version '2.1.9'
}

...

jlink {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
       name = 'helloFX'
    }
    forceMerge('log4j-api')     // <---- this is required for Log4j
}