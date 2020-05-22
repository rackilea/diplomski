task runJar(dependsOn:jar) << {
  javaexec { 
    main="-jar";
    args = [
            "C:/Users/nwuser/FitNesse/fitnesse-standalone.jar",
            "-c",
            "FrontPage?suite&format=text"
           ]
  } 
}