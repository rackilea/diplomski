public class Timertesttask extends TimerTask {
    Context ctxObject = null;
    public Timertesttask(Context ctx) {
        ctxObject = ctx;
    }

    @Override
    public void run() {
        Intent gpsintent = new Intent(ctxObject, Gps.class);
        ctxObject.startService(gpsintent);
    }
}