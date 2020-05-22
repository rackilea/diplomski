FileReader fileReader=new FileReader(tmpFile);
    int ch= fileReader.read();
    while(ch != -1){
    System.out.print((char)ch);
    ch = fileReader.read();
    }
    fileReader.close();