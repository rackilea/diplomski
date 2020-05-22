val supervisorStrategy =
      AllForOneStrategy {
        case e: Throwable => 
            notifyUser(e)
            Stop
      }