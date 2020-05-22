//Open your local db as the input stream
    InputStream myInput = myContext.getAssets().open(DB_IN);

    // Path to the just created empty db
    String outFileName = DB_PATH + DB_NAME;

    //Open the empty db as the output stream
    OutputStream myOutput = new FileOutputStream(outFileName);

    //transfer bytes from the input file to the output file
    byte[] buffer = new byte[1024];
    int length;
    while ((length = myInput.read(buffer))>0){
        myOutput.write(buffer, 0, length);
    }

    //Close the streams
    myOutput.flush();
    myOutput.close();
    myInput.close();