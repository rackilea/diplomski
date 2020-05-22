public class MyReciever extends BroadcastReceiver {
@Override
    public void onReceive(Context context, Intent intent) { 
        String action = intent.getAction();
        if(action!=null && action.equals(CUSTOM_ACTION)){
           //do something 
        }
    }
}