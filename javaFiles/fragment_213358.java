repositories {    
    jcenter()
    flatDir {
        dirs 'libs'
    }
}

dependencies {
    compile(name:'KTplay', ext:'aar')
}

android {
    packagingOptions {
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/LICENSE'
    }
}