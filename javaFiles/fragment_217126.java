apply plugin: "java"

dependencies {
    compile "org.lwjgl:lwjgl:3.2.0"
    if (buildos == "windows") {
       compile "org.lwjgl:lwjgl-platform:3.2.0:natives-windows"
    } else if (buildos == "linux") {
       compile "org.lwjgl:lwjgl-platform:3.2.0:natives-linux"
    } else if (buildos == "osx") {
       compile "org.lwjgl:lwjgl-platform:3.2.0:natives-osx"
    }
}



gradle build -Pbuildos=windows