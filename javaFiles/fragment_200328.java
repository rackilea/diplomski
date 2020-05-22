private final AtomicReference<Map<Datacenters, List<SocketHolder>>> liveSocketsByDatacenter 
    = new AtomicReference<>(Collections.unmodifiableMap(new HashMap<>()));

...

private void connectToZMQSockets() {
    ...
    // Update the map content
    this.liveSocketsByDatacenter.set(Collections.unmodifiableMap(liveSockets));
}

public Optional<SocketHolder> getNextSocket() {
    // For the sake of consistency make sure to use the same map instance
    // in the whole implementation of my method by getting my entries
    // from the local variable instead of the member variable
    Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter = 
        this.liveSocketsByDatacenter.get();
    ...
}

// Added the modifier synchronized to prevent concurrent modification
// it is needed because to build the new map we first need to get the
// old one so both must be done atomically to prevent concistency issues
private synchronized void updateLiveSockets() {
    // Initialize my new map with the current map content
    Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter = 
        new HashMap<>(this.liveSocketsByDatacenter.get());
    ...
    // Update the map content
    this.liveSocketsByDatacenter.set(Collections.unmodifiableMap(liveSocketsByDatacenter));
}