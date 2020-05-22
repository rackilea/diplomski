public class ClientHandler extends Thread
{
  public static final Map<ClientHandler, BlockingQueue<String>> messageQueues 
    = new ConcurrentHashMap<>();

  <snip>

  public ClientHandler(Socket client)
  {
    super("ClientHandler");
    this.client = client;
    // Note: Bad practice to reference 'this' in a constructor.
    // This can throw an error based on what the put method does.
    // As such, if you are to do this, put it at the end of the method.
    messageQueues.put(this, new ArrayBlockingQueue<>());
  }

  // You can now access this in the run() method like so:
  // Get messages for the current client.
  // messageQueues.get(this).poll();
  // Send messages to the thread for another client.
  // messageQueues.get(someClient).offer(message);