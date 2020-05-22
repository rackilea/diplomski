android {
...
    configurations.all {
            resolutionStrategy.force "com.android.support:support-v4:${supportLib}"
            resolutionStrategy.force "com.android.support:appcompat-v7:${supportLib}"
            resolutionStrategy.force "com.android.support:design:${supportLib}"
            resolutionStrategy.force "com.android.support:recyclerview-v7:${supportLib}"
            resolutionStrategy.force "android.arch.lifecycle:runtime:${lifecycleExtensions}"
        }
}