public static void startAddGoogleAccountIntent(Context context)
{
    Intent addAccountIntent = new Intent(android.provider.Settings.ACTION_ADD_ACCOUNT)
    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    addAccountIntent.putExtra(Settings.EXTRA_ACCOUNT_TYPES, new String[] {"com.google"});
    context.startActivity(addAccountIntent); 
}