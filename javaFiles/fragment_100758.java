public class Serv extends Service {

    String t,msg1;
    int id;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
//ConnectionDetector  is custom class for detecting internet connection
//isCD() returns true if internet connection available


                if(cd.isCD())    
                   getData();

            }
        }, 0,360000);


        return START_STICKY;

    }