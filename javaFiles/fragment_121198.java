ExecutorService executor = Executors.newFixedThreadPool(10);

while(resultSet.next())
{
    name=resultSet.getString("hname");
    MyRunnable worker = new  MyRunnable(name);
    executor.submit(worker);
    counter++;
}


executor.shutdown();
System.out.println("thread shutdown");

executor.awaitTermination(60, TimeUnit.SECONDS);
System.out.println("Finished all threads");