class DBResult{}
class DBRequest implements Callable<DBResult>{
    @Override
    public DBResult call(){return new DBResult();}
}
class AsyncTest{
   public void test(){
     try {
         for(Future<DBResult> futureResult : ((ExecutorService)executor).invokeAll(listRequest)){
             futureResult.get();
         }
     } catch (InterruptedException | ExecutionException ex) {
         Logger.getLogger(SoTest.class.getName()).log(Level.SEVERE, null, ex);
     }
   }
}