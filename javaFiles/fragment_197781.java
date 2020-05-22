String mp3Directory = "/Music/Overkill";
 String directoryPath=Environment.getExternalStorageDirectory().getPath() + mp3Directory; 
 List<File> list = getMP3Files(directoryPath); 

//print in LogCat the list of .mp3:
for (File file : list) {     
        Log.i("MP3 File name", file.getName());
    }