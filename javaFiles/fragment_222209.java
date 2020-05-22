int counter = 5;
    Handler handler = new Handler();

    ArrayList<String> messageItems = new ArrayList<>();
    messageItems.add("Message 1");
    messageItems.add("Message 2");
    messageItems.add("Message 3");

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            counter--;
            if (counter > 0) {
                Log.d("HOME", "onCreate: countdown " + counter + " " + System.currentTimeMillis());
                handler.postDelayed(this, 1000);
            }
            if (counter == 1) {
                for (int j = 0; j < messageItems.size(); j++) {
                    final int jdx = j;
                    Handler handler1 = new Handler();
                    handler1.postDelayed(() -> {
                        Log.d("HOME", "onCreate: countdown " + messageItems.get(jdx) + " " + System.currentTimeMillis());
                    }, 3000 * jdx);
                }
            }
        }
    };

    Log.d("HOME", "onCreate: countdown 5 " + System.currentTimeMillis());
    handler.postDelayed(runnable, 1000);