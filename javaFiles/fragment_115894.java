task generateWasDeployment {
   doLast {
      exec {
         workingDir 'build' 
         commandLine(['cmd', '/c', "${websphereHome}/bin/ejbdeploy.bat"]) 
         args file("$build/${component.name}.jar") 
         args ... 
         args ... 
      } 
      delete "$build/${componentName}.jar" 
      file("$build/${componentName}-deployed.jar").renameTo(file("$build/${componentName}.jar")) 
   } 
}