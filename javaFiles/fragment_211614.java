try {
    RandomAccessFile store = new RandomAccessFile(file, "rw");
    String dummy = "Empty record                                                           ";
    for (int i = 0; i < MAX_RECORD_NUMBER; i++) {
       store.writeUTF(dummy);
    }
} catch (FileNotFoundException e){
    System.err.println("File cannot be created!");
}