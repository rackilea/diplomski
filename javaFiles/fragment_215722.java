package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.channel.Channel;

public final class NioChannelUtil {
  public static long getWriteTaskQueueCount(Channel channel) {
    NioSocketChannel nioChannel = (NioSocketChannel) channel;
    return nioChannel.writeBufferSize.get();
  }
}