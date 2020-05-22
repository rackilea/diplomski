File sdCard = Environment.getExternalStorageDirectory();
File dir = new File(sdCard.getAbsolutePath() + File.separator
                        + "/imotax");
dir.mkdirs();
File f= new File(dir, fileToCreate);
if(!f.exists()){
f.createNewFile();
}

fis = new FileInputStream(f);