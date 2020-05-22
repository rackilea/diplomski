int bytesRead = 0;
int bytesAvailable = gzis.available();
while (bytesAvailable > 0){
    gzis.read(bbuffer,bytesRead,bytesAvailable);
    bytesRead += bytesAvailable;
    bytesAvailable = gzis.available();
}