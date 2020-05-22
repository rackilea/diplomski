SetOfSources {
    main {
        java {
            include 'com/macao/somePackage/activityAdapter/**'
            include 'com/macao/someOtherPackage/**'
            exclude 'com/macao/someOtherPackage/pollingAdapter/**'
            exclude 'com/macao/someOtherPackage/matchingAdapter/**'
        }
    }
}