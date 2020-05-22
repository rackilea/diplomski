android {
    defaultConfig.ndk {
        …
        abiFilter 'armeabi'
    }

    splits {
        abi {
            enable true
            reset()
            include 'armeabi'
        }
    }
}