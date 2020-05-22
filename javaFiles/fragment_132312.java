public class SMSObserver extends ContentObserver
{
SMSLogger smsLogger;
Context context;

public SMSObserver(SMSLogger smsLogger, Context c) {
    super(new Handler());
    context = c;
    this.smsLogger = smsLogger;
}

protected void querySMS() {
    Uri uriSMS = Uri.parse("content://sms/");
    Cursor cur = context.getContentResolver().query(uriSMS, null, null, null, null);
}
}