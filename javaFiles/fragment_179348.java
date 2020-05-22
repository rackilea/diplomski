@SuppressWarnings("unchecked")
public <T extends Object> T getChannelColumn(ChannelContentModel.channelColumns column) {
    switch (column) {
        case id:
            return (T) channel.getId(); //int must be Integer
        case title:
            return (T) channel.getChannelTitle();
    }
    return null;
}