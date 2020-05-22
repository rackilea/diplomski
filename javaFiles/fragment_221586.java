repositories {
    jcenter()
    maven { 
        url 'https://oss.sonatype.org/content/repositories/snapshots' 
    }
}

ext.CHARM_DOWN_VERSION = "1.0.0"

dependencies{
    compile "com.gluonhq:charm-down-common:$CHARM_DOWN_VERSION"

    desktopRuntime "com.gluonhq:charm-down-desktop:$CHARM_DOWN_VERSION"
    desktopRuntime 'org.xerial:sqlite-jdbc:3.9.0-SNAPSHOT'

    androidRuntime "com.gluonhq:charm-down-android:$CHARM_DOWN_VERSION"
    androidRuntime 'org.sqldroid:sqldroid:1.0.3'

    iosRuntime "com.gluonhq:charm-down-ios:$CHARM_DOWN_VERSION"
}