final int progress = diggingStatus; //get only the current
                        // Update the progress bar
                        diggingHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                diggingbar.setProgress(progress);
                                if(progress==100)
                                     Log.d("i got called","i got called ");
                            }
                        });