task sourcesJar(type: Jar) {
//Comment out the below line
//from android.sourceSets.main.java.srcDirs 
classifier = 'sources'

}

artifacts {
  archives sourcesJar
}