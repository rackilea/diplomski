Bitmap screen = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+         
File.separator +"img.png");

//my code for saving
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    screen.compress(Bitmap.CompressFormat.JPEG, 15, bytes);

//you can create a new file name "test.jpg" in sdcard folder.

File f = new File(Environment.getExternalStorageDirectory()+ File.separator + "test.jpg");
            f.createNewFile();
//write the bytes in file
    FileOutputStream fo = new FileOutputStream(f);
    fo.write(bytes.toByteArray());
// remember close de FileOutput

    fo.close();