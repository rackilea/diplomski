Future future = myData.getFuture();     
try {
    Future<String> future1 = (Future<String>) future.get(); 
    System.out.println(future1.get().toString());
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}