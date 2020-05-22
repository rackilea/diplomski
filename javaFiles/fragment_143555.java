apply plugin: 'java'

ext.libraries = [

   junit: 'junit:junit:4.12',
   mockito: 'org.mockito:mockito-all:1.9.5'

]

repositories {
  mavenCentral()
}

dependencies {
  testCompile(
    [
      libraries.junit,
      libraries.mockito
    ]
  )
}