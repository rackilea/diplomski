setAudio.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
               ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 11);

        }  else {
              //You already have the permission, just go ahead.
                 if (Build.VERSION.SDK_INT < 19) {
                      intent = new Intent();
                      intent.setAction(Intent.ACTION_GET_CONTENT);
                      intent.setType("*/*");
                      startActivityForResult(intent, 1);
                 } else {
                      intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                      intent.addCategory(Intent.CATEGORY_OPENABLE);
                      intent.setType("*/*");
                      startActivityForResult(intent, 1);
                 }
       }
}