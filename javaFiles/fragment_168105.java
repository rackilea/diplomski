// This example implements the asynchronous request and callback with Futures that have the
// interface of Java 8's futures (which is the same one followed by Flink's Future)

/**
 * An implementation of the 'AsyncFunction' that sends requests and sets the callback.
 */
class AsyncDatabaseRequest extends RichAsyncFunction<String, Tuple2<String, String>> {

/** The database specific client that can issue concurrent requests with callbacks */
private transient DatabaseClient client;

@Override
public void open(Configuration parameters) throws Exception {
    client = new DatabaseClient(host, post, credentials);
}

@Override
public void close() throws Exception {
    client.close();
}

@Override
public void asyncInvoke(final String str, final AsyncCollector<Tuple2<String, String>> asyncCollector) throws Exception {

    // issue the asynchronous request, receive a future for result
    Future<String> resultFuture = client.query(str);

    // set the callback to be executed once the request by the client is complete
    // the callback simply forwards the result to the collector
    resultFuture.thenAccept( (String result) -> {

        asyncCollector.collect(Collections.singleton(new Tuple2<>(str, result)));

    });
  }
}

// create the original stream (In your case the stream you are mappartitioning)
DataStream<String> stream = ...;

// apply the async I/O transformation
DataStream<Tuple2<String, String>> resultStream =
AsyncDataStream.unorderedWait(stream, new AsyncDatabaseRequest(), 1000, TimeUnit.MILLISECONDS, 100);