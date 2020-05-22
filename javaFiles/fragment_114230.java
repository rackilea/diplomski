try {
    File file = new File( fileName);
    if( !file.exists() || file.length() == 0) { 
        // Create the file, initialize it with some default value
    }
    in = new ObjectInputStream(new FileInputStream( file));
    score = (Score)in.readObject();
} catch() {
    ...
}