package com.mycompany.rns;

imports are listed here...

public class MyService extends IntentService {

    public MyService(){
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        system.out.println("At fucking last!");
    }
}