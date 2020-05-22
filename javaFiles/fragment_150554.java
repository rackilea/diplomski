try(DataInputStream in= new DataInputStream(new BufferedInputStream(new FileInputStream(new File("file"))))){
    int numValues=in.readInt();
    for(int i=0;i<numValues;i++){
        int x = in.readInt();
        int y = in.readInt();
    }
}