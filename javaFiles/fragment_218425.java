final Handler h = new Handler();
final int delay = 5000; // milliseconds

h.postDelayed(new Runnable() {
        public void run() {
            // do something
            final SharedPreferences sharedPref = getSharedPreferences(
                    getString(R.string.prefs), Context.MODE_PRIVATE);
            if (sharedPref != null) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // SOME CODE
                        Log.d("UPDATING"," something here");
                        isUpdated = updateToServer(data);
                        if(isUpdated) {
                            sharedPref.edit().putBoolean("updated",true).commit();
                            stopSelf();
                        }
                    }
                }).start();
            }
            if(!isUpdated){
               h.postDelayed(this, delay);
            }

        }
    }, delay);