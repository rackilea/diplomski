if(reader.readLine()!=null) {
    StringTokenizer tokens = new StringTokenizer(

    // this will read first line and separates values by (,) and stores them in tokens.
    (String) reader.readLine(), ",");

    tokens.nextToken(); // this method will read the tokens values on each call.
}