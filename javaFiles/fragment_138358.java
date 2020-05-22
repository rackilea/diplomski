kamon {
  metric {
    filters {
      trace.includes = [ "**" ]
      akka-actor.includes = [ "**" ]
      akka-actor.excludes = ["*/system/**", "*/user/IO-**" ]
      akka-dispatcher.includes = [ "**" ]
      akka-dispatcher.excludes = [ ]
    }
  }
 }