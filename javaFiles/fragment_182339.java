// create the connection
var nc:NetConnection = new NetConnection();
nc.connect("rtmp://localhost/myApp");

// create the stream
var ns:NetStream = new NetStream(nc);
ns.publish("myStreamName", "record");