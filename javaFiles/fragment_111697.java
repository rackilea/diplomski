private boolean perform(Operation operation) {
  if(station.getState == Station.Closed)
    return false;
  operation.run();
  return true;
}