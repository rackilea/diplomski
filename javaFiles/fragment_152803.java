buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'org.javafxports:jfxmobile-plugin:1.0.6'
    }
}

apply plugin: 'org.javafxports.jfxmobile'

repositories {
    jcenter()
}

dependencies {
    compile 'mysql:mysql-connector-java:3.1.12'
}

mainClassName = 'com.gluonhq.testsql.TestSQL'

jfxmobile {
    android {
        manifest = 'src/android/AndroidManifest.xml'
        packagingOptions {
            exclude 'META-INF/INDEX.LIST'
        }
    }
    ios {
        forceLinkClasses = [ 'com.gluonhq.**.*', 'com.mysql.**.*']
        infoPList = file('src/ios/Default-Info.plist')
    }
}