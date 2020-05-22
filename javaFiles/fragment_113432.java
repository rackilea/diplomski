/*get the path to internal storage*/
File path = Environment.getExternalStorageDirectory();
/*create the app folder and check if it exists or not*/
File curDir = new File(path.getAbsolutePath()+"/"+appName);
if(!curDir.exists()){
        curDir.mkdirs();
}
/*create the file*/
File f = new File(curDir+"/"+fileName);
f.createNewFile();
/*code to edit the file*/