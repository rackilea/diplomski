android {
...
externalNativeBuild {
    cmake {
        path "CMakeLists.txt"
    }
}
...
defaultConfig {
    externalNativeBuild {
        cmake {
            cppFlags "-std=c++14"
        }
    }
...
}