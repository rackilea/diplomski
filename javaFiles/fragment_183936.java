apply plugin: "maven-publish"

...

task createCrazyJar(type: Exec) {
  ...
}

publish {
  dependsOn "createCrazyJar"
}

publishing {
  publications {
    mavenJava(MavenPublication) {
      artifact createCrazyJar.outputs.getFiles().getSingleFile()
    }
  }
  repositories {
    maven {
      url project.repositories.maven.url
    }
  }
}