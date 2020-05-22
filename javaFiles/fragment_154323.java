thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i;
                        for (i = 0; i<10;i++){
                            final int finalI = i;
                            textCounter.post(new Runnable() {
                                @Override
                                public void run() {
                                    textCounter.setText(String.valueOf(finalI));
                                }
                            });
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ignored) {
                                Log.i(getClass().getSimpleName(), "Thread is interrupted");
                                return;
                            }
                            if (thread.isInterrupted()){
                                Log.i(getClass().getSimpleName(), "Thread is interrupted");
                                return;
                            }
                        }
                        textCounter.post(new Runnable() {
                            @Override
                            public void run() {
                                textCounter.setText("Done!");
                            }
                        });
                    }
                });