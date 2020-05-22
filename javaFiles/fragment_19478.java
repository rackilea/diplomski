Customer nextCustomer = vehicle.getNextCustomer();
 if (nextCustomer != null){
     scoreDirector.beforeVariableChanged(nextCustomer, "previousStandstill");
     nextCustomer.setPreviousStandstill(null);
     scoreDirector.afterVariableChanged(nextCustomer, "previousStandstill");
     scoreDirector.triggerVariableListeners();
 }