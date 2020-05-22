plugins {
  id 'application'
  id 'org.openjfx.javafxplugin' version '0.0.8'
  id 'org.beryx.jlink' version '2.15.1'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation group: 'com.jfoenix', name: 'jfoenix', version: '9.0.9'
}

javafx {
    version = "13"
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}

run {
    jvmArgs = [
            "--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix",
            "--add-exports=javafx.controls/com.sun.javafx.scene.control=com.jfoenix",
            "--add-exports=javafx.base/com.sun.javafx.binding=com.jfoenix",
            "--add-exports=javafx.graphics/com.sun.javafx.stage=com.jfoenix",
            "--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix",
    ]
}

jlink {
    launcher {
        name = 'hellofx'
        jvmArgs = [
                "--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix",
                "--add-exports=javafx.controls/com.sun.javafx.scene.control=com.jfoenix",
                "--add-exports=javafx.base/com.sun.javafx.binding=com.jfoenix",
                "--add-exports=javafx.graphics/com.sun.javafx.stage=com.jfoenix",
                "--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=com.jfoenix",
        ]
    }
}

mainClassName = "$moduleName/org.openjfx.MainApp"