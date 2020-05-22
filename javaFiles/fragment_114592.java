@Override
public void onReceive(Context context, Intent intent) {
    Intent i = new Intent(context.getApplicationContext(), BatteryChargerFast.class);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    i.putExtra("fast", true);
    context.startActivity(i);
}