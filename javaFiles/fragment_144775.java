Log.d("Executing :", "from here....\n");

try 
{
Calendar c1 = Calendar.getInstance();
c1.setTime(new Date());

Calendar c2 = Calendar.getInstance();
c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
c2.set(Calendar.MONTH, c1.get(Calendar.MONTH));
c2.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));
c2.set(Calendar.HOUR_OF_DAY, 0);
c2.set(Calendar.MINUTE, 0);
c2.set(Calendar.SECOND, 0);

long TodayStartedAt = c2.getTimeInMillis();

Log.d("Today started at ", "here" + TodayStartedAt);

final Uri SMS_INBOX = Uri.parse("content://sms/sent");
Cursor cursor = getContentResolver().query(SMS_INBOX, null, "date>=" + TodayStartedAt, null, null);
List < String > items = new ArrayList < String > ();

int counter = 0;

while (cursor.moveToNext()) 
{
    String Date = cursor.getString(cursor.getColumnIndex("date"));
    String SmsBody = cursor.getString(cursor.getColumnIndex("body"));
    String PhoneNumber = cursor.getString(cursor.getColumnIndex("address"));
    String FromSIM = cursor.getString(cursor.getColumnIndex("sub_id"));

    Log.d("Counter : ", counter + "\n");

    Log.d("Date : ", Date + "\n");
    Log.d("PhoneNumber : ", PhoneNumber + "\n");
    Log.d("FromSIM : ", FromSIM + "\n");
    Log.d("SmsBody : ", SmsBody + "\n");

    counter++;
}
cursor.close();
} 
catch (Exception e) 
{
Log.e("exception :", "is", e);
}