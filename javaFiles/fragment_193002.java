try {
    FileInputStream fis = new FileInputStream("*FILE*");
    try {
        player = new Player(fis);
    } catch(JavaLayerException | IOException e) {
        e.printStackTrace();
        fis.close(); // close stream on player creation failure

        // prevent access to uninitialized player variable by exiting the method
        throw new RuntimeException(e);
    }
} catch(IOException e){
    e.printStackTrace();

    // prevent access to uninitialized player variable by exiting the method
    throw new RuntimeException(e);
}