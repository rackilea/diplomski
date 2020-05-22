Selector selector = createSelector();
Channel channel = createChannelForSocket();

SelectionKey key = channel.register(selector);

while(true) {

  int readyChannels = selector.select(TIMEOUT);

  if(readyChannels == 0) continue;

  Set<SelectionKey> selectedKeys = selector.selectedKeys();

  for(SelectionKey key : selectedKeys) {

    if (key.isReadable()) {
        readDataFromChannel(key.channel())
    } else if (key.isWritable()) {
        writeDataToChannel(key.channel())
    }

  }
}