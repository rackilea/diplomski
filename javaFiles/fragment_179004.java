android {
    ...
    buildTypes {
        debug {
            buildConfigField "String", "BUILD_BRANCH", buildBranchName
        }
        ...
    }    
}