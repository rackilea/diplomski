ChannelService channelService = ChannelServiceFactory.getChannelService();

// The channelKey can be generated in any way that you want, as long as it remains
// unique to the user.
String channelKey = "xyz";
String token = channelService.createChannel(channelKey);