List<String> projectLibs = new ArrayList<String>()
task copyJars(type: Copy, dependsOn: subprojects.jar) {    

    eachFile { fileCopyDetails -> 
      projectLibs.add(fileCopyDetails.name)
    }
    from(subprojects.jar) 
    into file('lib')
}

task copyDeps(type: Copy, dependsOn: copyJars) {

    eachFile { fileCopyDetails ->      
      if (fileCopyDetails.name in projectLibs){
        fileCopyDetails.exclude()
      }
    }
    from (subprojects.configurations.runtime)
    into file('lib/ext')
}