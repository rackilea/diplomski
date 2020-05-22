int batchSize = 1000;
 int start=51234;
 int end=59265;
 for(int i = start; i < end + 1; i+=batchSize) {
   select * from database where id >= i and id < Math.min(i+batchSize, end);
 }