class PrintCurrentThreadAndResult implements IResult<String> {
   @Override
   public void onResult(String result) {
   Thread thread = Thread.currentThread();
    System.out.print(thread.getName());
    System.out.print(" - ");
    System.out.println(result);
   }
}