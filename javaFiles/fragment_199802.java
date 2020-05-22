FileOutputStream fOut = new FileOutputStream(file);
FileInputStream fIn = new FileInputStream(finalLocation);
byte data[] = new byte[4096];
long progress = 0;
int count;
int fileSize = connection.getContentLength();

while ((c = in.read()) != -1){
    //we should write the data before publish progress
    fOut.write(data, 0, count)
    try{
        Thread.sleep(100);
    }catch (InterruptedException ie){
        Log.e(TAG, "thread interrupted", ie);
    }finally {
        if (fileSize > 0){
            publishProgress((int) ((progress+=count)*100/fileSize));
        }
    }
}