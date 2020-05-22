//File sdCardDir = Environment.getExternalStorageDirectory();  
//File targetFile;
//targetFile = new File(sdCardDir.getCanonicalPath()  
                        + "/CalendarNote/"+ dateN);
String folderPath = getIntent().getStringExtra("folderpath");
File file=new File(folderPath + "/"+title+".txt");