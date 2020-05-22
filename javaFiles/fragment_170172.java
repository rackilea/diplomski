public void onClick(View v) {
            bt1.setBackgroundResource(R.drawable.picture);
            Thread thread = new Thread()
            {
                @Override
                public void run() {
                    try {
                            Thread.sleep(5000);
                            runOnUiThread(new Runnable(){public void run()
                            {
                                bt1.setBackgroundResource(R.drawable.pic);
                            }});    

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();


        }
    });