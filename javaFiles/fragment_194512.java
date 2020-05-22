WaitBlockHashMap.put(agent.qualityCheckID, agent)
if (WaitBlockHashMap2.get(agent.qualityCheckID)!=null) { //if the matching element 
                                                         //is on the other Wait Block
    self.free(agent);
    WaitBlock2.free(WaitBlockHashMap2.get(agent.qualityCheckID));
}