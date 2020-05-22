task copyJars {
   doLast {
         copy {
             from configurations.compile
             into "$buildDir/jars/compile" 
         } 
         copy {
             from configurations.runtime.minus(configurations.compile)
             into "$buildDir/jars/runtime" 
         } 
         copy {
             from configurations.testCompile.minus(configurations.compile)
             into "$buildDir/jars/testCompile" 
         }      
         copy {
             from configurations.testRuntime.minus(configurations.testCompile).minus(configurations.runtime)
             into "$buildDir/jars/testRuntime" 
         }      
    } 
}