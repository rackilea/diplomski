After adding this line, my dependencies body was like this:
dependencies {
compile fileTree(dir: 'libs', include: ['*.jar'])
compile 'com.android.support:appcompat-v7:22.0.0'
compile 'com.parse.bolts:bolts-android:1.+'
compile fileTree(dir: 'libs', include: 'Parse-*.jar')
compile fileTree(dir: 'libs', include: "commons-io-2.4.jar")  }