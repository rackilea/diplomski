void messageReceived(...) {
    HttpResponse res = new DefaultHttpResponse(...);
    res.setHeader(...);
    ...
    channel.write(res);
}

// In a different thread..
ChannelBuffer partialContent = ...;
channel.write(partialContent);