Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);

// the _ids you save goes here at the end of /data/12562     
intent.setDataAndType(Uri.parse("content://com.android.contacts/data/_id"),
    "vnd.android.cursor.item/vnd.com.whatsapp.voip.call");
intent.setPackage("com.whatsapp");

startActivity(intent);