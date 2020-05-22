private void handleRegistration(final Context context, Intent intent) {
        String registrationId = intent.getStringExtra(EXTRA_REGISTRATION_ID);
        String error = intent.getStringExtra(EXTRA_ERROR);
        String unregistered = intent.getStringExtra(EXTRA_UNREGISTERED);
        Log.d(TAG, "handleRegistration: registrationId = " + registrationId +
                ", error = " + error + ", unregistered = " + unregistered);

        // registration succeeded
        if (registrationId != null) {
            GCMRegistrar.resetBackoff(context);
            GCMRegistrar.setRegistrationId(context, registrationId);
            onRegistered(context, registrationId);
            return;
        }

        // unregistration succeeded
        if (unregistered != null) {
            // Remember we are unregistered
            GCMRegistrar.resetBackoff(context);
            String oldRegistrationId =
                    GCMRegistrar.clearRegistrationId(context);
            onUnregistered(context, oldRegistrationId);
            return;
        }

        // last operation (registration or unregistration) returned an error;
        Log.d(TAG, "Registration error: " + error);
        // Registration failed
        if (ERROR_SERVICE_NOT_AVAILABLE.equals(error)) {
            boolean retry = onRecoverableError(context, error);
            if (retry) {
                int backoffTimeMs = GCMRegistrar.getBackoff(context);
                int nextAttempt = backoffTimeMs / 2 +
                        sRandom.nextInt(backoffTimeMs);
                Log.d(TAG, "Scheduling registration retry, backoff = " +
                        nextAttempt + " (" + backoffTimeMs + ")");
                Intent retryIntent =
                        new Intent(INTENT_FROM_GCM_LIBRARY_RETRY);
                retryIntent.putExtra(EXTRA_TOKEN, TOKEN);
                PendingIntent retryPendingIntent = PendingIntent
                        .getBroadcast(context, 0, retryIntent, 0);
                AlarmManager am = (AlarmManager)
                        context.getSystemService(Context.ALARM_SERVICE);
                am.set(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + nextAttempt,
                        retryPendingIntent);
                // Next retry should wait longer.
                if (backoffTimeMs < MAX_BACKOFF_MS) {
                  GCMRegistrar.setBackoff(context, backoffTimeMs * 2);
                }
            } else {
                Log.d(TAG, "Not retrying failed operation");
            }
        } else {
            // Unrecoverable error, notify app
            onError(context, error);
        }
    }