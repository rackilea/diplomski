private final URI urlToPage;
private final String saveToFileName;

public JGet(String urlToPage, String saveToFilename) {

    if(urlToPage == null){
        throw new NullPointerException("The URL must not be null");
    }

    if(saveToFilename == null){
        throw new NullPointerException("The name of the destination file must not be null");
    }

    //some other questions we could ask
    //does this path exist? (we may let the stream creation fails later also
    //does the file exist? (ditto)
    //can we overwrite files (in this case we may stop it here)
    this.saveToFileName = saveToFilename;

    try {
            //is this actually a http URL?
            //we may check protocol
        this.urlToPage = new URI(urlToPage);
    } catch (URISyntaxException e) {
        throw new IllegalArgumentException("Invalid URL provided: "+ urlToPage);
    }
}