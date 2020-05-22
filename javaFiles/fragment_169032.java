Intent intent = new Intent ();
intent.setAction (Intent.ACTION_VIEW);

intent.setDataAndType (Uri.parse ("content://com.android.contacts/data/" + id), "vnd.android.cursor.item/vnd.com.whatsapp.voip.call");
intent.setPackage ("com.whatsapp");

startActivity (intent);