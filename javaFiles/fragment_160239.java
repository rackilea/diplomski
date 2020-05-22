DatabaseMiddleMan login = new DatabaseMiddleMan(0,uinfo,this.mHandler);
    Thread thread = new Thread(login);
    thread.start();
    ...
    // blah blah blah, here doing some actions in parallel, while thread doing it's work
    ...
    thread.join();

    Bundle b = login.mResult;        
    weCanMove = b.getBoolean("key");