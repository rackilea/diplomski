AmazonSNSClient snsClient = new AmazonSNSClient(new DefaultAWSCredentialsProviderChain());
    snsClient.setRegion(Region.getRegion(Regions.US_WEST_2));

    List<Topic> topicArns = new ArrayList<>();

    ListTopicsResult result = snsClient.listTopics();
    topicArns.addAll(result.getTopics());

    while (result.getNextToken() != null) {
        result = snsClient.listTopics(result.getNextToken());
        topicArns.addAll(result.getTopics());
    }

    for (Topic topic : topicArns) {
        System.out.println(topic.getTopicArn());
    }

    snsClient.shutdown();