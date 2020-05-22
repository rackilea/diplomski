public static void main(String[] args) {
    // define the file location
    String pathToFile = "C:\\temp\\websites.txt";
    // make it a java.nio.file.Path
    Path filePath = Paths.get(pathToFile);
    // define the new host for all the URIs
    String exchangeHost = "localhost.com";

    try {
        // stream the lines
        Files.lines(filePath)
                .forEach(line -> {
                    try {
                        // create a URI from the original
                        URI originalUri = new URI(line);
                        // and a new one using scheme of the original, but put the new host
                        URI updatedUri = new URI(originalUri.getScheme(), exchangeHost, 
                                originalUri.getPath(), originalUri.getFragment());
                        // print this change to the console
                        System.out.println(originalUri.toString()
                                            + "  ————>  "
                                            + updatedUri.toString());
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                });
    } catch (IOException e) {
        // handle IOException
        e.printStackTrace();
    }
}