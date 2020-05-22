//onCreate
lv = getListView();

if(ContextCompat.checkSelfPermission(this,
    Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
         getContacts();
 }