//                                              try and specify the charset if possible
//                                                             v     v
try(final Scanner sc = new Scanner( new File("N:\\data.json"), "UTF-8" )) {
    final String fileContents = sc.useDelimiter("\\A").next();
    parser.parse(fileContents);
    // ...
}