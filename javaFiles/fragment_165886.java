Server s = new Server;
int maxRetries = 10;
int retry = 0;
while(retry < maxRetries){
    try {
        retry++;
        // Read value to num somehow (scanner maybe)
        s.start(num);
    catch (IllegalArgumentException e){
        // print error string
    }
}