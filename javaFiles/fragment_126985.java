new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        someHeavyStuffHere(); //Big calculations or file download here.
                        handler.sendEmptyMessage(SUCCESS);
                    }
                    catch (Exception e)
                    {
                        handler.sendEmptyMessage(FAILURE);
                    }
                }
            }).start();