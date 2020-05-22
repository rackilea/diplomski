public class PhoneStateReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent launch = new Intent(context, AcitivityToLaunch.class);
            launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(launch);
        }
    }
}