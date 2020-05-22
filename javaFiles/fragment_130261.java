repositories {
  maven {
        credentials {
            username "$mavenUser"
            password "$mavenPassword"
        }
        authentication {
            basic(BasicAuthentication)
        }
        url "https://api.bitbucket.org/2.0/repositories/<Team>/<repo>/src/<branch>"
  }
}