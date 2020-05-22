public void onCreate(Bundle savedInstanceState) {
    ...
    try {
        URL url_g = new URL("http://www.google.com/");
    } catch(MalformedURLException e) {
        //Do something with the exception.
    }
    ...
}