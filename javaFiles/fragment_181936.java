// Start by querying the objectName of the Publication Point (Topic Space on a specific node).
         AdminClient adminClient = AdminClientFactory.createAdminClient(connectProps);
         StringBuffer oNameQuery= new StringBuffer();        
         oNameQuery.append(adminClient.getDomainName()).append(":*");
         oNameQuery.append(",type=").append("SIBPublicationPoint");
         oNameQuery.append(",name=").append("Default.Topic.Space");
         oNameQuery.append(",node=").append(nodeName); 
         oNameQuery.append(",process=").append("server1"); 
         oSet= adminClient.queryNames(new ObjectName(oNameQuery.toString()), null); 
         ObjectName defaultTopicSpaceOn = (ObjectName) oSet.iterator().next();
         System.out.println("Default.Topic.Space ObjectName:"+defaultTopicSpaceOn);

        // Then look at each subscription storing messages in the Publication Point.
        Long depth = (Long) adminClient.invoke (defaultTopicSpaceOn, "getDepth", null, null);
        System.out.println("DefaultTopicSpace Depth:"+depth+"\n");
        SIBSubscription[] subscriptions = (SIBSubscription[]) adminClient.invoke (defaultTopicSpaceOn, "getSubscriptions", null, null);
        for (SIBSubscription subscription : subscriptions) {
          System.out.print("DefaultTopicSpace Subscription:"+subscription.getName() 
                             +" Id:"+subscription.getId()
                             +" SubscriberId:"+subscription.getSubscriberId()
                             +" Selector:"+subscription.getSelector()
                             +" Depth:"+subscription.getDepth());
          for (String topicName: subscription.getTopics())
            System.out.print(" Topic:"+topicName);
          System.out.println();
        }