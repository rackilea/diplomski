InputStreamReader isr = new InputStreamReader(inpputStream, "UTF-8");
    char[] inputBuffer = new char[BUFFER_SIZE];

    while ((charsRead = isr.read(inputBuffer, 0, BUFFER_SIZE)) > 0) {
        String read = new String(inputBuffer, 0, charsRead);
        str += read;
    }