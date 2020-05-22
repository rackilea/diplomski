File f3=new File(Environment.getExternalStorageDirectory()+"/inpaint/");
if(!f3.exists())
    f3.mkdirs();        
OutputStream outStream = null;
File file = new File(Environment.getExternalStorageDirectory() + "/inpaint/"+"seconds"+".png");
try {
    outStream = new FileOutputStream(file);
    mBitmap.compress(Bitmap.CompressFormat.PNG, 85, outStream);
    outStream.close();
    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
} catch (Exception e) {
    e.printStackTrace();
}