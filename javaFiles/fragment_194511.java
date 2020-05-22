WaitBlockHashMap.put(agent.orderID, agent)
if (WaitBlockHashMap2.get(agent.orderID)!=null) { //if the matching element 
                                                  //is on the other Wait Block
    self.free(agent);
    WaitBlock2.free(WaitBlockHashMap2.get(agent.orderID));
}