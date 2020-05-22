new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                server = new ServerSocket(4444);
            }
        }).start();