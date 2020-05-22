allprojects {
    repositories {
       //...
    }

    subprojects {
        project.configurations.all {
            resolutionStrategy.eachDependency { details ->
                if (details.requested.group == 'com.android.support'
                && !details.requested.name.contains('multidex') ) {
                    details.useVersion "26.1.0"
                }
            }
        }
    }
}