int listSize = exList.size();

for (int shardNumber = 0; shardNumber < threads; shardNumber++) {
  new Thread(new Runnable() {
    public void run() {
      for(int listIndex = shardNumber*listSize; listIndex < (shardNumber+1)*listSize; listIndex++) {
        System.out.println(exList.get(listIndex));
      }
   }}).start();
}