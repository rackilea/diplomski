File file = ... //Create a temporary file on the filesystem your trying to reserve.
long bytes = ... //number of bytes you want to reserve.

RandomAccessFile rf = null;
try{
    rf = new RandomAccessFile(file, "rw"); //rw stands for open in read/write mode.
    rf.setLength(bytes); //This will cause java to "reserve" memory for your application by inflating/truncating the file to the specific size.

    //Do whatever you want with the space here...
}catch(IOException ex){
    //Handle this...
}finally{
    if(rf != null){
        try{
            rf.close(); //Lets be nice and tidy here.
        }catch(IOException ioex){
            //Handle this if you want...
        }
    }
}