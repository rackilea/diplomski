interface Command{

    //depending on your situation, 
    //either use InputStream if you don't know
    //how many bytes each Command will use
    // or the the commands will use an unknown number of bytes
    //or a large number of bytes that performance
    //would be affected by copying everything.
    void execute(InputStream in);

    //or you can use an array if the
    //if the number of bytes is known and small.
    void execute( byte[] data);

}