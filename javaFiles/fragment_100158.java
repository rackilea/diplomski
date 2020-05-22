private void setMetrics() {
        SharedPreferences sharedPreferences = Activity_Splash.this.getSharedPreferences("com.dmurphy.remotescrumpoker", Context.MODE_PRIVATE);
        //Check if device has a network connection
        boolean connectionExists = new NetworkConnection().haveNetworkConnection(passedActivity, TAG);

        //If device has a network connection continue
        if (connectionExists) {
            Log.i(" => ", "Test1");
            try {
                String userId = mAuth.getCurrentUser().getUid();
                int teamCreated2 = sharedPreferences.getInt("teamCreatedForMetrics", 0);
                Log.i(" => ", "Test2 " + teamCreated2);
                callMetrics.startupUpdateMetrics(userId, context);
                done=true;
            } catch (Exception e) {
                Log.e(TAG + "onCreate", "Error setting metrics");
            }
        }
    }