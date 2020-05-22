public static final ArrayList<String> sms_num = new ArrayList<String>();
public static final ArrayList<String> sms_body = new ArrayList<String>();


public static void getSmsLogs(Cursor c, Context con) {

    if (sms_num.size() > 0) {
        sms_num.clear();
        sms_body.clear();
    }

    try {

        if (c.moveToFirst()) {
            do {
                Log.d("error",
                        ""
                                + c.getString(c
                                        .getColumnIndexOrThrow("address")));
                if (c.getString(c.getColumnIndexOrThrow("address")) == null) {
                    c.moveToNext();
                    continue;
                }

                String Number = c.getString(
                        c.getColumnIndexOrThrow("address")).toString();
                String Body = c.getString(c.getColumnIndexOrThrow("body"))
                        .toString();

                sms_num.add(Number);

                sms_body.add(Body);
            } while (c.moveToNext());
        }
        c.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}