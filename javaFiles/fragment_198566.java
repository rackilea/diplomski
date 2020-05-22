androidTestCompile fileTree(dir: 'libs', include:'robotium-solo-5.3.0.jar')
androidTestCompile ('com.android.support:multidex-instrumentation:1.0.1') {
    exclude group: 'com.android.support', module: 'multidex' }

project.configurations.all { config ->
    if (config.name.contains("AndroidTest")) {
        config.resolutionStrategy.eachDependency { details ->
            if (details.requested.name == "multidex") {
                details.useTarget("de.felixschulze.teamcity:teamcity-status-message-helper:1.2")
            }
        }
    }
}