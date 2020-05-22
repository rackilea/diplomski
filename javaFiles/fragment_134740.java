apply plugin: 'com.android.application'

configurations {
    all*.exclude group: 'com.android.support', module: 'support-v4'
    all*.exclude group: 'com.google.android.gms', module: 'play-services'
}