plugins {
  id 'application'
  id 'org.openjfx.javafxplugin' version '0.0.8'
}

repositories {
    jcenter()
}

dependencies {
    implementation "de.jensd:fontawesomefx-commons:11.0"
    implementation "de.jensd:fontawesomefx-fontawesome:4.7.0-11"
}

mainClassName = 'org.openjfx.MainApp'

javafx {
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}