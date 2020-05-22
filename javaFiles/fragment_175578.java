public class Lot {
  private List<ClientThread> clients = new ArrayList<ClientThread>();
  private List<Integer> bids = new ArrayList<Integer>();

  public synchronized void subscribe(ClientThread t){
    clients.add(t);
  }

  public synchronized void unsubscribe(ClientThread t){
    clients.remove(t);
  }

  public synchronized void makeBid(int i){
    bids.add(i);
    for (ClientThread client : clients){
      client.lotUpdated(this);
    }
  }
}

public ClientThread {
  public void lotUpdated(Lot lot){
    //called when someone places a bid on a Lot that this client subscribed to
    out.println("Lot updated");
  }
}