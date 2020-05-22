allprojects {
  repositories {
   }

subprojects {
    project.configurations.all {
        resolutionStrategy.eachDependency { details ->
            if (details.requested.group == 'com.google.android.gms'
            && !details.requested.name.contains('multidex') ) {
                details.useVersion "12.0.1"
            }
        }
    }
}
}