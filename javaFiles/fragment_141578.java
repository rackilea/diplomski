apply plugin: 'war'

war {
  // dependsOn 'minify'

  from 'src/main/webapp'
  exclude 'css' // or: "exclude 'WEB-INF/classes/css'"

  from('build/tmp/css') {
    include '**/*.css'
    into 'css' // or: "into 'WEB-INF/classes/css'"
  }
}