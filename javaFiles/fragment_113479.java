if (Build.VERSION.SDK_INT >= 23) {
    if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
       //you code..
       //read_file()
    } else {
        //request permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
    }
}
else { 

    //permission is automatically granted on sdk<23 upon installation
    //Your code
    //read_file()
}