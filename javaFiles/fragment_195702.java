@Override
public void onReceive(Context context, Intent intent) {
   ...
   Intent callIntent = new Intent(Intent.ACTION_CALL);
   callIntent.setData(Uri.parse("tel:+107222222"));
   context.startActivity(callIntent);
}