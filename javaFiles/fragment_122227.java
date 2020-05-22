new Thread(new Runnable() {
        @Override
        public void run() {

            while (hasLoc == false && cancel == false) {
                float d = l.distanceTo(t);
                if (d < 2.0)
                    hasLoc = true;
                String msg = "Latitude: " + l.getLatitude() + "\nLongitude: " + l.getLongitude();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                    }
                });
            }

            hasLoc = false;

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 10 seconds
                    buzzer();
                }
            }, 10000);

            while (l.distanceTo(tf) > 2.0 && cancel == false) {
                float cSpeed = l.getSpeed();

                if (cSpeed > topSpeed)
                    topSpeed = cSpeed;

                String msg = "Current Speed: " + cSpeed + "Top Speed: " + topSpeed;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                    }
                });
            }

            cancel = false;

        }
    }).start();