while (true) {
       new Handler(Looper.getMainLooper()).post(new Runnable() {
       @Override
       public void run() {
             Toast.makeText(context, "Service Started", Toast.LENGTH_SHORT).show();
            }
        });
        Thread.sleep(2000);
      }