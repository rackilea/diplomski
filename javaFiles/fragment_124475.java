repositories {
    //central maven repo
    mavenCentral()
}

dependencies {
    //local file
    compile files('libs/toxiclibscore.jar')

    //dependencies from a remote repository
    compile 'java3d:vecmath:1.3.1', 'commons-lang:commons-lang:2.6'
}