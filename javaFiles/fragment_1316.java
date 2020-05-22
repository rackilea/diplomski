repositories {
  mavenLocal()
}

configurations {
  xsdSources { // Defined a custom configuration
    transitive = false // Not interested in transitive dependencies here
  }
}

dependencies {
  xsdSources "com.someCompany.someTeam.someProject:someProject-wsdl:$someVersion"
  xsdSources "com.someCompany.someTeam:otherArtifact:$otherVersion"
}

task copyWsdlFromArtifacts(type: Copy) {
  from configurations.xsdSources.files.collect { zipTree(it)}
  into "$buildDir/schema"
  include '**/*.xsd', '**/*.wsdl'
  includeEmptyDirs = false
}