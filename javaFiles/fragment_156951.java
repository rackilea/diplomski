loadProfile()

processResources {
    include '**/*'
    exclude 'profiles'
}

dependencies {
        compile (project(':project-api-autoconfigure')) {
            exclude module: 'project-module-a-api'
            exclude module: 'project-module-b-api'
            ...
        }
        ...
    }

...

def loadProfile() {
    def profile = hasProperty('profile') ? "${profile}" : "dev"
    println "Profile: " + profile
    apply from: "profiles/" + profile + ".gradle"
}