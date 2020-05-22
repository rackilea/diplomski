BufferedReader reader = new BufferedReader(
            new FileReader(file));
    char[] buf = new char[1024];
    int numRead=0;
    while((numRead=reader.read(buf)) != -1){
        String readData = String.valueOf(buf, 0, numRead);