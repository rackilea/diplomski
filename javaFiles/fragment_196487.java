// Tell Gradle where to find the ProGuard task.
    buildscript {
        repositories {
            mavenLocal() //in case it is already downloaded
            mavenCentral()
        }//end repositories

        dependencies { classpath 'net.sf.proguard:proguard-gradle:6.0.3' }
    }//end buildscript