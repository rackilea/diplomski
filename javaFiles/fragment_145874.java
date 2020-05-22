packagingOptions {
        pickFirst 'META-INF/LICENSE.txt' // picks the JavaMail license file
    }
repositories {
    jcenter()
    maven {
        url "https://maven.java.net/content/groups/public/"
    }
dependencies {
    compile 'com.sun.mail:android-mail:1.6.2'
    compile 'com.sun.mail:android-activation:1.6.2'
    provided files('libs/javax.mail.jar')
}