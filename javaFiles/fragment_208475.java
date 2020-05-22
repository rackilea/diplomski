Bitmap photo = (Bitmap) data.getExtras().get("data");// Get the Bitmap


  val file = File(context.cacheDir,"CUSTOM NAME") //Get Access to a local file. 
  file.delete() // Delete the File, just in Case, that there was still another File
  file.createNewFile() 
  val fileOutputStream = file.outputStream()
  val byteArrayOutputStream = ByteArrayOutputStream()
  photo.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream)
  val bytearray = byteArrayOutputStream.toByteArray()
  fileOutputStream.write(bytearray)
  fileOutputStream.flush()
  fileOutputStream.close()
  byteArrayOutputStream.close()

  val URI = file.toURI()