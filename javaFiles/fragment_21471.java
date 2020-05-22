androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
    exclude group: 'com.android.support', module: 'support-annotations'
})
androidTestCompile('com.android.support.test:runner:0.5', {
    exclude group: 'com.android.support', module: 'support-annotations'
})