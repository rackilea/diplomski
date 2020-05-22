int filename = curFileName.getColumnIndex("filename");
 if (cur.moveToFirst()) { // position cursor to first item. false: empty resultset
     String filenameString = curFileName.getString(filename);
     d = Drawable.createFromPath(Environment.getExternalStorageDirectory().toString()+filenameString);
     Toast.makeText(getApplicationContext(), filenameString, Toast.LENGTH_SHORT).show();
     handleDrawable(d);
     ...
 }