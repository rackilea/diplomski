// I have to store it in a field for late use.
    ILaunch launch = new Launch(null, ILaunchManager.DEBUG_MODE, null);
    ...
    // Then I can access the thread and call stepover or resume methods
    IDebugTarget target = launch.getDebugTarget(); 
    IThread[] threads = target.getThreads();
    threads[0].stepOver();
    threads[0].resume();
    threads[0].stepInto();