int numRead= 0;
int total =0;
int readSize =56;
while(numRead >= 0 && total < readSize) {
    numRead = this.in.read(inBytes, total, readSize - total); 
    if(numRead > 0) {
       total += numRead;
    }
}