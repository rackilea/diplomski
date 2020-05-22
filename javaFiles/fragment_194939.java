mediaFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath());


if (!mediaFile.exists()) {
    mediaFile.mkdir();
}
byte[] data2 = data.getBytes();

// Hold the reference to the file that you are writting
File txtFile = new File(mediaFile, "textfile.txt")
FileOutputStream f = new FileOutputStream(txtFile );

try {
    f.write(data2);
    f.flush();
    f.close();
} catch (IOException e) {
    e.printStackTrace();
}

// Here, use txtFile instead of mediaFile
fileUri =  Uri.fromFile(txtFile);
Log.d("TAHH" , "URI = "+fileUri);