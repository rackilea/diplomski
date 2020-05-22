int BUFFER = 4096;
    PipedOutputStream toAppPipedOutputStream;
    PipedInputStream toAppPipedInputStream;

    static BufferedReader fromAppBufferedReaderfinal;
    BufferedOutputStream fromAppOutputStream;
    PipedOutputStream fromAppPipedOutputStream;
    PipedInputStream fromAppPipedInputStream;

    /* constructor sets up logging and parameters */

           try { 
                fromAppPipedInputStream = new PipedInputStream(BUFFER);
                fromAppOutputStream=new BufferedOutputStream(new PipedOutputStream(fromAppPipedInputStream));
                fromAppBufferedReaderfinal=new BufferedReader(new InputStreamReader(fromAppPipedInputStream));
                CASUAL.Log.out = new PrintStream(fromAppOutputStream);

                toAppPipedInputStream = new PipedInputStream(BUFFER);
                toAppPipedOutputStream=new PipedOutputStream(toAppPipedInputStream);
                CASUAL.CASUALInteraction.in= new BufferedReader(new InputStreamReader(toAppPipedInputStream));