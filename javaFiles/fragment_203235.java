repositories {
  mavenCentral()
}

configurations {
  repoindex
}

dependencies {
  repoindex group: 'biz.aQute.bnd', name: 'org.osgi.impl.bundle.repoindex.cli', version: '3.0.0' 
}

defaultTasks = [':index']

task('index') {
  /* Bundles to index. */
  def bundles = fileTree(projectDir) {
    include '**/*.jar'
    exclude '**/*-latest.jar'
    exclude '.*/'
  }
  doLast {
    javaexec {
      main = '-jar' // first arg must be the jar
      args configurations.repoindex.singleFile
      args '-n', 'Local' // REPO NAME HERE
      args bundles*.absolutePath
    }.assertNormalExitValue()
  }
}