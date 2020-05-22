void load(){
    try{
        RandomAccessFile input=new  RandomAccessFile(fileName.getText() ,"r");
        byte buffer[]=new byte [(int) input.length()];
        input.read(buffer);
        input.close();
        String content = new String(buffer);
        fileBuffer.setText(content); 
        encryptedBuffer.setText(TestMD5.encryptionMD5(content));        
    }
    catch(IOException e) {System.out.println(e);}

}