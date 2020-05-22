public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null || !ACTION.equals(intent.getAction())) {
            return super.onStartCommand(intent, flags, startId);
        }
        String state = intent.getStringExtra(STATE);
        String phoneNo = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
        Log.d("tag", "state: " + state + " phoneNo: " + phoneNo);
        if (OUTGOING.equals(state)) {
            fileNamePrefix = "mob_no_s" + phoneNo + "mob_no_d" + OUTGOING_CALL_SUFFIX;
        } else if (INCOMING.equals(state)) {
            fileNamePrefix = "mob_no_s" + phoneNo + "mob_no_d" + INCOMING_CALL_SUFFIX;
        } else if (BEGIN.equals(state)) {
            if (SecurePreferences.getBooleanPreference(this, Constants.PREF_RECORD_CALLS)) {
                try {
                    startRecording();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (END.equals(state)) {
            try {
                stopRecording();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (STORAGE.equals(state)) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                prepareAmrDir();
            } else {
                isMounted = false;
            }
            if (!isInRecording) {
                stopSelf();
            }
        }
        return START_STICKY;
    }

    public Context getContext() {
        return cntx;
    }

    private void stopRecording() throws IOException {
        updateNotification(Boolean.valueOf(false));
        if (isInRecording) {
            isInRecording = false;
            try {
                recorder.stop();
                recorder.release();
                recorder = null;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            releaseWakeLock();
            if (SecurePreferences.getBooleanPreference(this, Constants.PREF_SAVE_RECORDING)) {
                Intent intent = new Intent(this, AutoRunReceiver.class);
                intent.putExtra("absolutepath", amr.getAbsolutePath());
                sendBroadcast(intent);
            }
            stopSelf();
            Log.d("tag", "call recording stopped");
        }
    }