@Bean
public ChannelCallerLookup channelCallerLookup(MessageDeliveryClient messageDispatcherClient, MessageDeliveryClient otherPickerDeliveryClient) {
    HashMap<String, MessageDeliveryClient> channelCallerLookup = new HashMap<>();
    channelCallerLookup.put(CHANNEL1_KEY, messageDispatcherClient);
    channelCallerLookup.put(CHANNEL1_KEY2, otherPickerDeliveryClient);
    ChannelCallerLookup callerLookup = new ChannelCallerLookup(channelCallerLookup);
    return callerLookup;
}