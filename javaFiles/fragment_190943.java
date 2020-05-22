if (cursor != null){
    cursor.moveToFirst();
    String string1 = cursor.getString(0);
    .... string2 = cursor.getString(1);
    .... string3 = cursor.getString(2);
    textView1.setText(string1);
    textView2.setText(string2);
    textView3.setText(string3);
}