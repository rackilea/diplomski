List<String> hosts = fetchTargetHosts();

int concurrentHosts = 10;
int concurrentConnections = 100;
ExecutorService hostEs=Executors.newWorkStealingPool(concurrentHosts);
ExecutorService connEs=Executors.newWorkStealingPool(concurrentConnections);

FileDownloader fileDownloader = new FileDownloader();
for(String host: hosts) hostEs.execute(()-> {
    for(String target: new HostDownloader(host).get())
        connEs.execute(()->fileDownloader.accept(target));
});