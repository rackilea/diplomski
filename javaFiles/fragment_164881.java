public void performParallelTask(List<LatLngPair> latLngPairList) throws InterruptedException {
CountDownLatch doneLatch = new CountDownLatch(latLngPairList.size());
for (int i = 0; i < latLngPairList.size(); i++) {
    addLatLngPair(doneLatch, latLngPairList.get(i));
}
doneLatch.await();