android {
    ...

    defaultConfig {
        ...
    }

    buildTypes {
        release {
        ...
    }

    buildTypes.each {
        it.buildConfigField 'String', 'MY_API_TOKEN_KEY', MyApiTokenValue
    }
}