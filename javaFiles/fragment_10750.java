apply plugin: "groovy"

// Spock works with Java 1.6 and above
sourceCompatibility = 1.6

repositories {
  // Spock releases are available from Maven Central
  mavenCentral()
  // Spock snapshots are available from the Sonatype OSS snapshot repository
  maven { url "http://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {
  // mandatory dependencies for using Spock
  compile "org.codehaus.groovy:groovy-all:2.4.10"
  testCompile "org.spockframework:spock-core:1.1-groovy-2.4"
}