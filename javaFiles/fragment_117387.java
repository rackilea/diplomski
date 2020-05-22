private static final int DEF_SMS_REQ = 0;
private String mDefaultSmsApp;

...

    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
    {
        mDefaultSmsApp = Telephony.Sms.getDefaultSmsPackage(this);

        if (!getPackageName().equals(mDefaultSmsApp))
        {
            Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
            intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, getPackageName());
            startActivityForResult(intent, DEF_SMS_REQ);
        }
    }       

...

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    switch (requestCode)
    {
        case DEF_SMS_REQ:           
            boolean isDefault = resultCode == Activity.RESULT_OK;
            ...
    }
}