for (UserThread thread : threadArray)
    {
        thread = new UserThread();
        thread.start();
    }

    for (UserThread thread : threadArray)
    {
        if (thread != null)
            thread.join();
    }