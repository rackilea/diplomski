plugins {
  id 'application'
  id 'org.openjfx.javafxplugin' version '0.0.8'
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    version = "13"
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}

mainClassName = 'org.openjfx.MainApp'