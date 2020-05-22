List<Future> futures = new ArrayList<> ();
//in the for loop
futures.add(executorService.submit(createTaskFor(item)));

//after for loop + add exception handling
for (Future f : futures) f.get();
//at this point all tasks have finished