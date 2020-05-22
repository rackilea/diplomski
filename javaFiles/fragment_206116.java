try {  
  // Getting QR-Code as Bitmap  
  bitmap = qrgEncoder.encodeAsBitmap();  
  // Setting Bitmap to ImageView  
  qrImage.setImageBitmap(bitmap);  
} catch (WriterException e) {  
  Log.v(TAG, e.toString());  
}