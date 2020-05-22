public byte[] getRunLength(){
    ByteArrayOutputStream dest = new ByteArrayOutputStream();  
    byte lastByte = imageByteArray[0];
    int matchCount = 1;
    for(int i=1; i < imageByteArray.length; i++){
        byte thisByte = imageByteArray[i];
        if (lastByte == thisByte) {
            matchCount++;
        }
        else {
            dest.write((byte)matchCount);  
            dest.write((byte)lastByte);
            matchCount=1;
            lastByte = thisByte;
        }                
    }
    dest.write((byte)matchCount);  
    dest.write((byte)lastByte);
    return dest.toByteArray();
}