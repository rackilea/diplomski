String columns = { "comment" };
String constraint = "PhoneNr=? AND Name=? AND comment=? AND Answered=?";
String args[] = { newn, contact, previuscom, Yn };

Cursor cursor = db.query("MyTab", columns , constraint, args, null, null, null);
String comments = cursor.getString(cursor.getColumnIndex("comment"));
comments += text.getText().toString();