if isUser(request){ 
    session.lastRobotAccess == null
}else{
    if (session.lastRobotAccess == null) {
       session.lastRobotAccess = current_time
    } else {
       if(current_time - session.lastRobotAccess > session.timeout){
          session.invalidate
       }
    }
}