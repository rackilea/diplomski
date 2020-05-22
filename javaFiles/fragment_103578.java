public class AlertFlash implements Runnable {

    public static volatile int flashes;
    boolean suspendFlag, end;

    private Activity activity;
    private View view;

    public AlertFlash (int flashNo, Activity activity, View view) {
        flashes = flashNo * 2;
        suspendFlag = false;
        end = false;

        this.activity = activity;
        this.view = view;
    }

    public void run() {
        for (int i = 0; i<=flashes; i++) {

            if (suspendFlag = false) {
                AircraftMain.flashOn = true;
                suspendFlag = true;
            }
            else {
                AircraftMain.flashOn = false;
                suspendFlag = false;
            }

            final int visibility = AircraftMain.flashOn ? View.VISIBLE : View.GONE;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view.setVisibility(visibility);
                }
            });

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        end = true;
    }
}