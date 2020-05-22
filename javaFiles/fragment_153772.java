public class Main Activity extends Activity {

        DateTime recordingStartedTime;
        DateTime recordingEndedTime = null;
        boolean buttonHeldLongEnough = false;
        LimitRecordingTask limitRecordingTask;

        PackageManager pm = getPackageManager();
        boolean micPresent = pm.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);

        if (micPresent) {
            recordBtn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View recordView, MotionEvent recordEvent) {

                    limitRecordingTask = new LimitRecordingTask();
                    switch (recordEvent.getAction()) {

                        case MotionEvent.ACTION_DOWN:
                            // Try to record audio
                            try {
                                recordBtn.setBackgroundColor(Color.DKGRAY);
                                recordingOff.setVisibility(View.INVISIBLE);
                                recordingOn.setVisibility(View.VISIBLE);

                                recordingStartedTime = DateTime.now();
                                constructPrepareStartRecording();
                                limitRecordingTask.resetRecordingTimer();
                            }
                            catch (Exception ex) {
                                Log.e(MainActivity.class.getSimpleName(), "An unknown error occurred.");
                                limitRecordingTask.stopRecordingTimer();
                            }
                            return true;

                        case MotionEvent.ACTION_UP:
                            // After 3 seconds limitRecordingTask will 'steal' this event
                            recordBtn.setBackgroundResource(R.drawable.custom_button);
                            recordingOff.setVisibility(View.VISIBLE);
                            recordingOn.setVisibility(View.INVISIBLE);

                            recordingEndedTime = DateTime.now();
                            Seconds seconds = Seconds.secondsBetween(recordingStartedTime, recordingEndedTime);
                            int secondsButtonHeld = Math.abs(seconds.getSeconds());

                            if (secondsButtonHeld > 0 ) {
                                buttonHeldLongEnough = true;
                            }
                            else {
                                buttonHeldLongEnough = false;
                            }
                            return true;
                    }
                    return false;
                }
            });
        }
        else {
            toastTitle = "Unable To Record";
            toastMessage = "Device microphone not found.";
            toast = new GenericCustomToast();
            toast.show(toastTitle, toastMessage, MainActivity.this);
        }

        private class LimitRecordingTask {

            public final long RECORDING_TIMEOUT = 3000; // 3 seconds

            private Handler limitRecordingHandler = new Handler(){
                public void handleMessage(Message msg) {
                }
            };

            private Runnable limitRecordingCallback = new Runnable() {
                @Override
                public void run() {
                    // 'Stolen' MotionEvent.ACTION_UP
                    recordBtn.setBackgroundResource(R.drawable.custom_button);
                    recordingOff.setVisibility(View.VISIBLE);
                    recordingOn.setVisibility(View.INVISIBLE);

                    if (recordingEndedTime == null) {
                        recordingEndedTime = DateTime.now();
                    }
                    Seconds seconds = Seconds.secondsBetween(recordingStartedTime, recordingEndedTime);
                    int secondsButtonHeld = Math.abs(seconds.getSeconds());

                    if (secondsButtonHeld > 0 ) {
                        buttonHeldLongEnough = true;
                    }
                    else {
                        buttonHeldLongEnough = false;
                    }

                    limitRecordingTask.stopRecordingTimer();

                    stopReleaseResetRecording();
                    itemLookup();
                }
            };

            public void resetRecordingTimer(){
                limitRecordingHandler.removeCallbacks(limitRecordingCallback);
                limitRecordingHandler.postDelayed(limitRecordingCallback, RECORDING_TIMEOUT);
            }

            public void stopRecordingTimer(){
                limitRecordingHandler.removeCallbacks(limitRecordingCallback);
            }
        }
    }