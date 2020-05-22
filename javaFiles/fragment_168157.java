@Override
public void onReceive(Context context, Intent intent){
    if(intent.getAction().equals("ACTION_APPWIDGET_DISABLED"){
        context.unregisterReceiver(this);
    }
    else{
        ...
        //Rest of my method
    {

{