public static final int  SUBSCRIBER_A_ID = 1;
    ....
    try {
        JPost.getBroadcastCenter().addSubscriber(ChannelIds.publicChannel1, subscriberA, SUBSCRIBER_A_ID);
    }catch (Exception e){
        e.printStackTrace();
    }