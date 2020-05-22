apply plugin: 'com.android.model.application'
model {
    android {
        compileSdkVersion = 21
        buildToolsVersion = "22.0.1"

        defaultConfig.with {
            applicationId = "com.mycompany.mygame"
            minSdkVersion.apiLevel = 15
            targetSdkVersion.apiLevel = 21
            versionCode = 1
            versionName = "1.0"
        }
    }
    android.buildTypes {
        release {
            minifyEnabled = false
            proguardFiles += file('proguard-rules.pro')
        }
    }
    android.ndk {
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Collision".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Collision/Shapes".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Contacts".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Joints".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Particle".toString()
        CFlags += "-I${projectDir}/src/main/jni/Box2D/Rope".toString()

        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Collision".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Collision/Shapes".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Contacts".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Joints".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Dynamics/Particle".toString()
        cppFlags += "-I${projectDir}/src/main/jni/Box2D/Rope".toString()
        moduleName = "liquidfun"
    }
}
def liquidFunDir = new File("${projectDir}/src/main/java/com/google/fpl/liquidfun")

task createLiquidFunDir {
    liquidFunDir.mkdirs()
}
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:22.2.1'
}