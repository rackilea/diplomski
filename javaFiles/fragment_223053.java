private ZooKeeper zk;
final CountDownLatch connectionLatch = new CountDownLatch(1);

public void yourMethod() {

    zk = new ZooKeeper(zkConnect, 2000, new Watcher() {

        public void process(WatchedEvent we) {
            if (we.getState() == KeeperState.SyncConnected) {
                connectionLatch.countDown();
            }
        }
    });

    connectionLatch.await();

    // Now we have connected to zookeeper.
    // Now, we can fetch configuration safely.
    byte[] fetched = zk.getData(CONFIG_ZNODE_PATH, false, null);
    return deserializeProps(fetched);
}