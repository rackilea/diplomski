View v = view.getRootView();
v.setDrawingCacheEnabled(true);
Bitmap b = v.getDrawingCache();

// give path of external directory to save image
String extr = Environment.getExternalStorageDirectory().toString();
File myPath = new File(extr, "test.jpg");
FileOutputStream fos = null;

try {
    fos = new FileOutputStream(myPath);
    b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
    fos.flush();
    fos.close();       
} catch (Exception e) {       
    e.printStackTrace();
}