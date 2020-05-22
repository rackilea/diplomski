//Find the directory for the SD Card using the API
//*Don't* hardcode "/sdcard"
File sdcard = Environment.getExternalStorageDirectory();

//Get the text file
File oldFile = new File(sdcard,"/temp/red.txt");

File newFile = new File(sdcard,"/temp5/red.txt");