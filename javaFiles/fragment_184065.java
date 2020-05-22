EventExecutorGroup executorGroup = new DefaultEventExecutorGroup(numberOfThreads);

...

public void initChannel(Channel ch) { 
    ch.pipeline()
      .addLast(new HttpRequestDecoder())
      .addLast(new HttpObjectAggregator(Int.MaxValue))
      .addLast(new HttpResponseEncoder())
      .addLast(new ChunkedWriteHandler())
      .addLast(new ResponseBodyDecoder())
      .addLast(executorGroup, new MyBusinessLogic());
}