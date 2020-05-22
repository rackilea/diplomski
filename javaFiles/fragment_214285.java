Intent intent = new Intent(this, MyService.class);

    //starting the service
    startService(intent);
    /*bind service to the actvitiy so that they can communicate between each    
     other*/
    bindService(intent, serviceconnection, Context.BIND_AUTO_CREATE);