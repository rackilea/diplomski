public class GCMBroadcastReceiver extends BroadcastReceiver {
DBController controller ;
HashMap<String, String> queryValues; 

 @Override
    public void onReceive(Context context, Intent intent) {
         controller =new DBController(context);
    }