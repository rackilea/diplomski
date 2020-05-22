JMSServerMBean[] jmsSvrs = dem.getJMSServers();

for(JMSServerMBean jmsSvr : jmsSvrs){
   System.out.println("JMS Servername: "+jmsSvr.getName());

   TargetMBean[] targets = jmsSvr.getTargets()
   for(TargetMBean target : targets)
   {
      if ( target.getName() == "cluster you care about")
      {
          JMSQueueMBean[] queues = jmsSvr.getJMSQueues();
          ...
      }
   }
 }