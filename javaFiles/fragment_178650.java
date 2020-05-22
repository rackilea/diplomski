public byte[] getRunLength(){
    ByteArrayOutputStream dest = new ByteArrayOutputStream();        
    for(int i =0; i < imageByteArray.length; i++){
        int runlength = 1;
        while(i+1 < imageByteArray.length && imageByteArray[i] == imageByteArray[i+1]){
            runlength++;
            i++;

        }     

        dest.write((byte)runlength);  
        dest.write((byte)imageByteArray[i]);
    }
    return dest.toByteArray();
}