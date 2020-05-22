Map<String, Future> tasks = new HashMap<String, Future>();
        while(i++ < 50){
            //In the extreme case I will have 50 threads and only 4 will be active and remaining are in queue 
            Thread myThread = new Thread();
            tasks.put("Thread"+i ,executor.submit(myThread));//Each Thread process 100,000 records and put in a file
        }
        // say you want to terminate Thread2 after 60 seconds
        Future thread2Task = tasks.get("Thread2");
        thread2Task.get(60, TimeUnit.SECONDS);
        thread2Task.cancel(true); // boolean whether you want to interrupt the thred forcefully