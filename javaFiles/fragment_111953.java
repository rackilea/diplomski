android {
  ...
  defaultConfig {
    ...
    // This block is different from the one you use to link Gradle
    // to your CMake or ndk-build script.
    externalNativeBuild {

      // For ndk-build, instead use the ndkBuild block.
      cmake {

        // Passes optional arguments to CMake.
        arguments "-DANDROID_ARM_NEON=TRUE", "-DANDROID_TOOLCHAIN=clang"

        // Sets a flag to enable format macro constants for the C compiler.
        cFlags "-D__STDC_FORMAT_MACROS"

        // Sets optional flags for the C++ compiler.
        cppFlags "-fexceptions", "-frtti"
      }
    }
  }

  buildTypes {...}

  productFlavors {
    ...
    demo {
      ...
      externalNativeBuild {
        cmake {
          ...
          // Specifies which native libraries or executables to build and package
          // for this product flavor. The following tells Gradle to build only the
          // "native-lib-demo" and "my-executible-demo" outputs from the linked
          // CMake project. If you don't configure this property, Gradle builds all
          // executables and shared object libraries that you define in your CMake
          // (or ndk-build) project. However, by default, Gradle packages only the
          // shared libraries in your APK.
          targets "native-lib-demo",
                  // You need to specify this executable and its sources in your CMakeLists.txt
                  // using the add_executable() command. However, building executables from your
                  // native sources is optional, and building native libraries to package into
                  // your APK satisfies most project requirements.
                  "my-executible-demo"
        }
      }
    }

    paid {
      ...
      externalNativeBuild {
        cmake {
          ...
          targets "native-lib-paid",
                  "my-executible-paid"
        }
      }
    }
  }

  // Use this block to link Gradle to your CMake or ndk-build script.
  externalNativeBuild {
    cmake {...}
    // or ndkBuild {...}
  }
}