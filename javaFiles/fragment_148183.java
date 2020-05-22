implementation "com.folioreader:folioreader:0.5.4"
implementation 'com.android.support:multidex:1.0.3' // ( for androidx)
configurations.matching { it.name == '_internal_aapt2_binary' }.all {
    config ->
        config.resolutionStrategy.eachDependency {
            details -> details.useVersion("3.3.2-5309881")
        }

}