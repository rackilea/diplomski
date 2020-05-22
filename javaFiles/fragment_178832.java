private void setProgressValue(final int progress) {

        // set the progress
        simpleProgressBar.setProgress(progress);

        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    if(simpleProgressBar.getProgress() == simpleProgressBar.getMax())
                    {
                         runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                           startB.setVisibility(View.VISIBLE);
                                        }
                                    });

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);


            }
        });
        thread.start();

    }