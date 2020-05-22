public String BitMapToString(Bitmap bitmap){
     ByteArrayOutputStream baos=new  ByteArrayOutputStream();
     bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
     byte [] b=baos.toByteArray();
     String temp=Base64.encodeToString(b, Base64.DEFAULT);
     return temp;
}