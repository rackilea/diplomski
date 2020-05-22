public List<String> getChannelsForUsername(String username) {
    List<String> userChannels = new ArrayList<String>();
    for (String channel : channels.keySet()) {
        if (channels.get(channel).contains(username)) {
            userChannels.add(channel);
        }
    }
    return userChannels;
}