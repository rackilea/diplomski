buildScript {
  ext {
    nav_version = "2.3.0-alpha01"
    kotlin_version = "1.3.50"
  }

    dependencies {
            classpath 'com.android.tools.build:gradle:3.5.3'
            classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}"
            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files

            classpath "androidx.navigation:navigation-safe-args-gradle-plugin:${nav_version}"
    }
}