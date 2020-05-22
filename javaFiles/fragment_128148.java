final Handler h = new Handler();
            h.post(new Runnable() {
                @Override
                public void run() {

                    long millis = (long) currentTime();

                    dateAndTime.setText(getDate(millis, "dd/MM/yyyy hh:mm:ss.SSS"));

                    h.postDelayed(this, 1000);
                }
            });