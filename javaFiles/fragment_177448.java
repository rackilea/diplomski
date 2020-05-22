ProgressMonitorInputStream input = new ProgressMonitorInputStream(
         null, 
         "Reading: " + file, 
         new FileInputStream(file));

    ProgressMonitor monitor = input.getProgressMonitor();
    // do some configuration for monitor here

    int ch;
    do {
        ch = input.read();
        // note: writing also the last -1 value
        exitStream.writeUTF(String.valueOf(ch)); 
    } while(ch != -1);

    input.close();