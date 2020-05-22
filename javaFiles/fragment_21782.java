new TimerTask() {
            int i =  t;
            public void run() {
                System.out.println(i--);
                if (i< 0)
                {
                    startActivity(intent);
                    timer.cancel();
                }
            }
        }, 0, 1000);