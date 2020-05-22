@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();

    //recibo la alarma
    if(action.contains("com.name.package.ACTION_FOR_ALARM")){
        [...]   // <-- your code for the notification
    }
 }