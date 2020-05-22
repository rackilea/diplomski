if (file.isDirectory()) {
    String[] contents = file.list();
    StringBuilder sb = new StringBuilder();
    for (String name: contents) {
        sb.Append(name);
        sb.Append("\n");
    }

    HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
    response.setContent(ChannelBuffers.copiedBuffer(sb.toString(), CharsetUtil.UTF_8));
    response.setHeader(CONTENT_TYPE, "text/plain; charset=UTF-8");

    if (isKeepAlive(request)) {
        response.setHeader(CONTENT_LENGTH, response.getContent().readableBytes());
        response.setHeader(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
    }

    ChannelFuture future = e.getChannel().write(response);
    if (!(isKeepAlive(request)) {
        future.addListener(ChannelFutureListener.CLOSE);
    }

    return;
}