final ProgressBar pbar = (ProgressBar) findViewById(R.id.bar); // Final so we can access it from the other thread
pbar.setVisibility(View.VISIBLE);

// Create a Handler instance on the main thread
Handler handler = new Handler();

// Create and start a new Thread
new Thread(new Runnable() { 
    public void run() {
         try{
             Thread.sleep(5000);
         }
         catch (Exception e) { } // Just catch the InterruptedException

         // Now we use the Handler to post back to the main thread
         handler.post(new Runnable() { 
            public void run() {
               // Set the View's visibility back on the main UI Thread 
               pbar.setVisibility(View.INVISIBLE);
            }
        });
    }
}).start();