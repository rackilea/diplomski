while (inStr != null) {
    StringTokenizer dogTok = new StringTokenizer(inStr, ",");

    while (dogTok.hasMoreTokens()) {
        [...]
    }
    System.out.println("dog " + i + " is stored");
    inStr = in.readLine();
    i++; //replaced here 
}