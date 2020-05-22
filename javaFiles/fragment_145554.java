for (Task task : tasks) {
   Callable<Void> c = new Callable<>() {
      public void call() {
         if (task.getCategories().isEmpty() || task.getEventList() == null || task.getMetaInfo() == null) {
               // ... rest of code here
          }
       }
    };
    executorService.submit(c);
 }

// wait for executor service, check for exceptions or whatever else you want to do here