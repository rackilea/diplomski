public class MyService extends Service {

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    Log.i("","startcommand is called");








    return START_STICKY; //restart automatically if service destroyed   
}


/*your code write it here for downloading your images and text ,you should   
 use asyntask inside it*/
public void startDownloading(){


}

//this IBinder is used for communicating with your activity
private final IBinder binder=new MyBinder();



//this use for binding with activity
@Override
public IBinder onBind(Intent intent) {
    return binder;
}



/*this class used only by the activity to access the service through it 
,will work only this way*/
public class MyBinder extends Binder {
        public MyService getService(){
            return MyService.this;
        }



 }

 }//end class