if(event.getSource() == btnAdd){

   Stage stage     = Waiting();   // Returns Waiting Message
   Task <Void> task = new Task<Void>() {

       @Override
       protected Void call() throws Exception {           
           Pass_data_from_java_to_report();         // My Method     
           return null;

       }

  };

    // Displaying Waiting Message
    task.setOnRunning(eve -> {
        stage.show();
    });

    // Closing Waiting Message
    task.setOnSucceeded(e -> {
        stage.close();

        // below from here i want to execute upon thread completion
        System.out.println("Finish "); 

    });

    // Thread for executing task
    Thread t1 = new Thread(task);

    t1.start();


}