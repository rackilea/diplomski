String strUriCalls = "content://call_log/calls";

Uri UriCalls = Uri.parse(strUriCalls);

Cursor cc = getContext().getContentResolver().query(UriCalls, null, null, null, null);

int number = cc.getColumnIndex(CallLog.Calls._ID);

int date = cc.getColumnIndex(CallLog.Calls.DATE);

if (cc.getCount() <= 0)

{
    Toast.makeText(getContext(), "Call log empty", Toast.LENGTH_SHORT).show();

}

while (cc.moveToNext()) {


    String callNumber = cc.getString(number);





    String callDate = cc.getString(date);
    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    try {
        systemDate = Calendar.getInstance().getTime();
        String myDate1 = sdf.format(systemDate);