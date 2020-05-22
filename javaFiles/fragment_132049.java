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