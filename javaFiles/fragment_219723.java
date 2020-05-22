public class SOSBroadcastReceiver extends BroadcastReceiver
{

    private static long lastTriggerTime = 0;
    private static final int ONE_MILLI = 1000;
    protected static final long ONE_SEC = 1 * ONE_MILLI;
    protected static final long TWO_SEC = 2 * ONE_MILLI;
    protected static final long THREE_SEC = 3 * ONE_MILLI;
    protected static final int TRIGGER_THRESHOLD = 3;

    protected static boolean triggerInProgress = false;

    protected static int triggerCounter = 0;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().contains(Intent.ACTION_SCREEN_ON))
        {
            if (!triggerInProgress)
            {
                checkAndCreateAlert(context);
            }

        }
        else if (intent.getAction().contains(Intent.ACTION_SCREEN_OFF))
        {
            if (!triggerInProgress)
            {
                checkAndCreateAlert(context);
            }
        }
    }

    private void checkAndCreateAlert(Context context)
    {

        /*---- If the gap between power button press is less than 2 seconds ----*/
        if ((System.currentTimeMillis() - lastTriggerTime) <= TWO_SEC
                || (triggerCounter == 0))
        {
            triggerCounter++;
            lastTriggerTime = System.currentTimeMillis();
        }
        else
        {
            triggerCounter = 0;
        }

        if (triggerCounter > TRIGGER_THRESHOLD)
        {
            ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(1000);
            triggerInProgress = true;

            Intent intent = new Intent(context, SOSActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("timer", true);
            context.startActivity(intent);

            triggerInProgress = false;
            triggerCounter = 0;
        }
    }
}