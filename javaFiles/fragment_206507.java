InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader bufReader = new BufferedReader(reader);
    String userInputLine = bufReader.readLine();
    //
    // write one line data to the file
    OutputStream out = new FileOutputStream(file);
    OutputStreamWriter writer = new OutputStreamWriter(out);
    writer.write(new String(userInputLine.getBytes("UTF-8")));
    writer.flush();