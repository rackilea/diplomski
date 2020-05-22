plugins {
    id 'jvm-component'
    id 'java-lang'
}

model {
  buildTypes {
    debug
    release
  }
  flavors {
    free
    paid
  }
    components {
        server(JvmLibrarySpec) {
            sources {
                java {
                  if (flavor == flavors.paid) {
                    // do something to your sources
                  }
                  if (builtType == buildTypes.debug) {
                    // do something for debuging
                  }
                    dependencies {
                        library 'core'
                    }
                }
            }
        }

        core(JvmLibrarySpec) {
            dependencies {
                library 'commons'
            }
        }

        commons(JvmLibrarySpec) {
            api {
                dependencies {
                    library 'collections'
                }
            }
        }

        collections(JvmLibrarySpec)
    }
}