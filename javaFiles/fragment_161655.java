ChannelService channelService = ChannelServiceFactory.getChannelService();

// This channelKey needs to be the same as the one in the first section above.
String channelKey = "xyz"

// This is what actually sends the message.
channelService.sendMessage(new ChannelMessage(channelKey, "Hello World!"));