new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        calculateGameChangesHere();
                        handler.sendEmptyMessage(SUCCESS);
                    }
                    catch (Exception e)
                    {
                        handler.sendEmptyMessage(FAILURE);
                    }
                }
            }).start();