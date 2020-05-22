shadowJar {
  baseName = 'myproject-shadow'
  classifier = ''
}

publishing {
  publications {
    shadow(MavenPublication) {
      from components.shadow
      artifactId = 'myproject-shadow'
    }
  }
}