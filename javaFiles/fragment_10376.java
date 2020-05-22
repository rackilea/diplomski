channel.closeFuture().addListener((ChannelFutureListener) future -> {
// not success wait and retry
if(future.channel().attr(OneAttribute) == some value){
     trySleep();
}
// close normally, no error, release so can create another connection immediately
this.channelPool.release(future.channel());