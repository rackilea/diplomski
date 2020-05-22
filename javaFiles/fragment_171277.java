channel.getCloseFuture().addListener(new ChannelFutureListener() {
    @Override
    public void operationComplete(ChannelFuture future) throws Exception {
            doSomething();
    }
});