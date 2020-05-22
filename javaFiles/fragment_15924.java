public void onMessage(Message msg){
   ProjData pd = extractProjectData(msg);
   if( projectLocked(pd) ) {
     msg.setStringProperty("projectId",pd.getProjectId());
     sendToOnHoldQueue(pd);
   }else{
    processProjectData(pd);
   }
}

// Say there is an event somewhere when the lock is released
public void onProjectLockReleased(projectId){
   // select messages waiting for this project via Jms selectors..

   // you may or may not want to lock the project here, while working of the "on hold events"
   MessageConsumer consumer = session.createConsumer(onHoldQueue,"projectId='"+projectId+"'");
   while(Messages msg  = consumer.receiveNoWait()){
     processProjectData(pd); 
   }
}