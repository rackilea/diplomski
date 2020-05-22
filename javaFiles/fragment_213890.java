//stream to get output from memory
    InputStream fromProcess = proc.getInputStream();
    InputStream fromError = proc.getErrorStream();

    int x;

    try {
        while((x = fromProcess.read()) != -1)
            System.out.print((char)x);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        while((x = fromError.read()) != -1)
            System.err.print((char)x);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    int exit = proc.exitValue();
    System.out.println("Exited with code " + exit);