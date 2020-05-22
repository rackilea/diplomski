buildscript {
    repositories {
        maven {
            url "http://my-nexus:6666/nexus/content/groups/public/"
        }
    }

    dependencies {
        classpath "org.ajoberstar:gradle-git:1.7.2"
    }
}

apply plugin: "org.ajoberstar.grgit"