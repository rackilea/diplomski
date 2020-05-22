class Process1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Some string from this callable";
    }
}
// Insert implementation for Process2 and Process2 Callables
   ...

public static void main(String[] args) throws Exception {
   ExecutorService executor = Executors.newFixedThreadPool(3);

   Future<String> process1Future = executor.submit(new Process1());
   Future<String> process2Future = executor.submit(new Process2());
   Future<String> process3Future = executor.submit(new Process3());

   // It will wait here 
   String processedStringByProcess1 = process1Future.get();
   String processedStringByProcess2 = process2Future.get();
   String processedStringByProcess3 = process3Future.get();

   StringBuilder builder = new StringBuilder();
   builder.append(processedStringByProcess1);
   builder.append(processedStringByProcess2);
   builder.append(processedStringByProcess3);

   System.out.println(builder.toString());
}