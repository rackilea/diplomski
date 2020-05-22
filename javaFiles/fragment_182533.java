if (action != null){
        // This is for registration
        if (action.equals("com.google.android.c2dm.intent.REGISTRATION")){
            Log.d(LOG_TAG, "Received registration ID");

            final String registrationId = intent.getStringExtra("registration_id");
            String error = intent.getStringExtra("error");

            Log.d(LOG_TAG, "dmControl: registrationId = " + registrationId + ", error = " + error);

            // Create a notification with the received registration id

            // Also save it in the preference to be able to show it later

            // Get the device id in order to send it to the server
            String deviceId = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
            // .. send it to the server
        }
        // This is for receiving messages
        else if (action.equals("com.google.android.c2dm.intent.RECEIVE")){
            String payload = intent.getStringExtra("payload");
            Log.d(LOG_TAG, "Message received: " + payload);
            // .. create a notification with the new message
        }