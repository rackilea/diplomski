buildscript {
   repositories {
      mavenLocal()
      mavenCentral()
      maven { url "https://repo.spring.io/libs-release" }
   }

   dependencies {
      classpath("org.springframework.boot:spring-boot-gradle-plugin:1.2.2.RELEASE")
   }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'spring-boot'



jar {
   baseName = 'gs-relational-data-access'
   version =  '0.1.0'
}

repositories {
   mavenLocal()
   mavenCentral()
   maven { url "http://repository.pentaho.org/artifactory/repo/" }
   maven { url "https://repo.spring.io/libs-release" }
}

dependencies {
   compile("org.springframework.boot:spring-boot-starter")
   compile("org.springframework:spring-jdbc")
   compile("org.olap4j:olap4j:1.1.0")
   compile("com.h2database:h2")
   testCompile("junit:junit")
}

task wrapper(type: Wrapper) {
   gradleVersion = '1.11'
}

task copyDeps(type: Copy) {
   from configurations.compile
   into 'deps'
}