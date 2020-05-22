private final QuotaLimitChecker limitChecker;

public MessageDecoder() {
    this.limitChecker = new QuotaLimitChecker();
}


@Override 
public void channelRead(ChannelHandlerContext ctx, Object msg) {
    if (limitChecker.quotaReached(100)) { //assume limit is 100 req per sec
        return;
    }
}