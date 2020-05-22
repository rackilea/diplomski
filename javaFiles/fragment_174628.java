public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContactList();
                loadListView();
                loadContactsIntoDb();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the list", Toast.LENGTH_SHORT).show();
            }
        }
    }