@Override
public void onMessageReceived(String from, Bundle data) {
    //...parse received data
    Intent updateStatus = new Intent("FILTER_NAME");
    updateStatus.putExtra("ITEM_ID_OR_NAME", id_or_name);
    updateStatus.putExtra("ITEM_STATUS", item_status);//-1, 0, 1
    LocalBroadcastManager.getInstance(this).sendBroadcast(updateStatus);
    //...
}