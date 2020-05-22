apply plugin: 'com.android.application'

task intergrationTest(type: Exec) {
    def adb = android.getAdbExe().toString()
    commandLine "$adb", 'shell', 'am', 'instrument', '-w', '-r', '-e',
            'debug', 'false', '-e', 'class', 'de.app.id.PullRequestTests',
            'de.app.id.app_test.debug.test/android.support.test.runner.AndroidJUnitRunner'
}