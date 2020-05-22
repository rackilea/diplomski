getActivity().finish();
            intent = new Intent(getContext(), MyApplicationStub.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            handler = new Handler();
            timer = new Timer();    
            initializeTimerTask();
            timer.schedule(timerTask, 500);

public void initializeTimerTask() {

            timerTask = new TimerTask() {
                public void run() {

                    //use a handler to run a toast that shows the current timestamp
                    handler.post(new Runnable() {
                        public void run() {
                            getContext().startActivity(intent);
                        }
                    });
                }
            };
        }