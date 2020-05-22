public interface P2PNetwork<N extends P2PNetwork<N, C>,
                            C extends P2PClient<N, C>> {
  void addClient(C client);
}

public interface P2PClient<N extends P2PNetwork<N, C>,
                            C extends P2PClient<N, C>> {
  void setNetwork(N network);
}

class TorrentNetwork implements P2PNetwork<TorrentNetwork, TorrentClient> {
  @Override
  public void addClient(TorrentClient client) {
    ...
  }
}

class TorrentClient implements P2PClient<TorrentNetwork, TorrentClient> {
  @Override
  public void setNetwork(TorrentNetwork network) {
    ...
  }
}

...

TorrentNetwork network = new TorrentNetwork();
TorrentClient client = new TorrentClient();

network.addClient(client);