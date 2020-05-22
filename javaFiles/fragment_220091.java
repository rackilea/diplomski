apply plugin: 'java'

repositories {
   mavenCentral()
}

dependencies {
   compile 'rhino:js:1.7R2'   
}

task runJS(type: JavaExec) {
   classpath configurations.compile
   main 'org.mozilla.javascript.tools.shell.Main'
   args 'run.js'
   standardOutput = new FileOutputStream(project.file('stdout'))
   errorOutput = new FileOutputStream(project.file('stderr'))
}