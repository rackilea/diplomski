// Don't use the connection on all queries at the same time
// unless that's allowed.
Future<String> f1 = executor.submit(new Callable<String>() {
     public String call() {
         return getQuantityVisitedPages( createConnection() );
     }});
Future<String> f2 = executor.submit(new Callable<String>() {
     public String call() {
         return getQuantityFoundLinks( createConnection() );
     }});


 try {
   // wait until f1 is finished and get the result
   // in the mean time all queries are running
   String qvp = f1.get(); 
   String qfl = f2.get();
 } catch (ExecutionException ex) { cleanup(); return; }

 // do something with found values