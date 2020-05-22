if(commandString.equals("PUT")){
    File f = new File(currentFolder, "test.txt");
    if(!f.exists())
         f.createNewFile();
    FileOutputStream fout = new FileOutputStream(f);
    long size = 150;
    long count = 0;

    byte[] buffer = new byte[512];
    int bufferLeng = buffer.length;
    while(count < size && bufferLeng>0) //dis is a data input stream.
    {

        fout.write(buffer);
        count =+ bufferLeng;
    }
    System.out.println("All Good");
    fout.flush();
    fout.close();

}