final List<Thread> workers = new ArrayList<Thread>();
for (int p = 0; p < 10; p++)
    {
        final int i = p;
        final Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(200);//or do something a bit more useful
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        workers.add(t);
        t.start();
    }

    for(Thread t : workers)
       t.join();//wait until the thread finishes