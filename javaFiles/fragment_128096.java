mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
int entryNumber = 1;

File mFile = new File(mFileName + "/AudioRecording_" + String.valueOf(entryNumber) + ".3gp");
while(mFile.exists()) {
   entryNumber++;
   mFile = new File(mFileName + "/AudioRecording_" + String.valueOf(entryNumber) + ".3gp");
}

this.mFileName = mFile.getAbsolutePath();