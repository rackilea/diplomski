ant.withGroovyBuilder {
  "java"( 
     "fork" to true, 
     "spawn" to true, 
     "classname" to "org.h2.tools.Server", 
     "dir" to projectDir
   ){
      "arg"("value" to "-tcp")
      "arg"("value" to "-web")
      "arg"("value" to "-tcpPort")
      "arg"("value" to "9092")
      "arg"("value" to "-webPort")
      "arg"("value" to "8082")
      "arg"("value" to "-webAllowOthers")
      "classpath" {
        "pathelement"(
                "path" to configurations["runtime"].asPath
            )
      }
   }
}