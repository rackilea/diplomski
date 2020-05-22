play {
  akka {
    akka.loggers = ["akka.event.Logging$DefaultLogger", "akka.event.slf4j.Slf4jLogger"]
    loglevel = WARNING
    actor {
      default-dispatcher = {
        fork-join-executor {
          parallelism-min = 1
          parallelism-factor = 2
          parallelism-max = 6
        }
      }
      my-context {
        fork-join-executor {
          parallelism-min = 1
          parallelism-factor = 4
          parallelism-max = 16
        }
      }
    }
  }
}