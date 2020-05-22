Thread thread = new Thread(new Runnable()
        {
            int lastMinute;
            int currentMinute;
            @Override
            public void run()
            {
                lastMinute = currentMinute;
                while (true)
                {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    currentMinute = calendar.get(Calendar.MINUTE);
                    if (currentMinute != lastMinute){
                        lastMinute = currentMinute;
                        Log.v("LOG", "your code here");
                    }
                }
            }
        });
        thread.run();