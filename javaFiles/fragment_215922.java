InputStream is;

// if we were getting data from a file, we might use:
is = new FileInputStream("/path/to/file");

// or, from a URL, then retrieve an InputStream from a URL
is = new URL("http://google.com/").openStream();