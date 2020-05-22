List<JSONObject> resultList = Collections.synchronizedList(new ArrayList<JSONObject>());
System.out.println("thread pool started");
ExecutorService exec = Executors.newFixedThreadPool(2);
for (int i=0; i<1; i++){  
    exec.execute(new Porshe(resultList));
    exec.execute(new Ferrari(resultList));
}
exec.shutdown();

...

System.out.println("And the result is: " + resultList);