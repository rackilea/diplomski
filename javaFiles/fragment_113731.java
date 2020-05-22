while (!connectionsList.isEmpty()) {
  for(Connection connection : connectionsList) {

    if connection.getState() == READY_FOR_A {
      connection.stepA();
      //this method should return immediately and the connection
      //should go into the waiting state for some time before going
      //into the READY_FOR_B state
    }
    if connection.getState() == READY_FOR_B {
      connection.stepB();
      //same immediate return behavior as above
    }
    if connection.getState() == READY_FOR_C {
      connection.stepC();
      //same immediate return behavior as above
    }
    if connection.getState() == WAITING {
      //Do nothing, skip over
    }
    if connection.getState() == FINISHED {
      connectionsList.remove(connection);  
    }
  }
}