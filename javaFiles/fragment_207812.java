Thread thread = new Thread(new Runnable()
                {
                    @Override public void run()
                    {

                        Thread embeddedNonDaemon = new Thread(new Runnable()
                                {
                                    @Override public void run()
                                    {
                                        while (true)
                                        {
                                            ;
                                        }
                                    }
                                });

                        embeddedNonDaemon.setDaemon(false);
                        embeddedNonDaemon.start();
                    }
                });

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);