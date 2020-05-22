apply plugin: 'idea'

dependencies {
    compile group: 'org.hibernate', name: 'hibernate-jpamodelgen', version: '5.3.3.Final'
}

idea {
   module {
       sourceDirs += file("build/generated/src/main/java")
   }
}