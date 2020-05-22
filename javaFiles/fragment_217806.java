// this needs to be volatile because another thread is accessing it
private volatile boolean shutdown;
...

@JmxOperation(description = "Shutdown the server")
public void shutdownSystem() {
   // this is set by the JMX connection thread
   shutdown = true;
}