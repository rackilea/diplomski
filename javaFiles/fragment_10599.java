private class BatteryLifeTask extends AsyncTask<Void, Void, Void> {
         protected void doInBackground(Void... params) {
             // Get the initial battery level
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = this.registerReceiver(null, ifilter);
            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            System.out.println("Initial battery level is: " + level);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            final float batteryPctTemp0 = level / (float) scale;
            final float batteryPct0 = batteryPctTemp0 * 100;
         }

         protected void onPostExecute() {
            int waitTime = 60000 * interval; // 1 minute is 60000 miliseconds
            Runnable r = new Runnable() {
                @Override
                public void run(){
                   new BatteryLifeTask.execute();
                }
            };
            Handler h = new Handler();
            h.postDelayed(r, waitTime);
         }
 }