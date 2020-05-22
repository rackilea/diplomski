@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
   super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   if (requestCode == 11) {
       if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
           //The External Storage READ Permission is granted to you... Continue your left job...
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
       } else{
           //permission denied
       }
}