plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.5'
    id 'org.beryx.jlink' version '2.1.8'
}

repositories {
    mavenCentral()
}

dependencies {
    compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.1'
}

javafx {
    modules = ['javafx.controls', 'javafx.fxml']
}

mainClassName = "${moduleName}/eu.sample.app.Main"

jlink {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'helloFX'
    }
}