bufferSize = 512;
buffer = new byte[bufferSize];
// Read file
bytesRead = fileInputStream.read(buffer, 0, bufferSize);
progress=0;

while (bytesRead > 0)
{   

    progress+=bytesRead;
    outputStream.write(buffer, 0, bytesRead);
    bytesAvailable = fileInputStream.available(); 
    publishProgress((int)((progress*100)/(file.length())));
    bufferSize = Math.min(bytesAvailable, maxBufferSize);
    buffer = new byte[bufferSize];
    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
}//end of while statement
fileInputStream.close();
publishProgress(100); 
outputStream.flush();
outputStream.close();