public static Algorythm loadAlgo(int n) throws IOException {
    try {
        return Class.forName("mypackage.Alg" + num).newInstance();

    } catch (Exception e) { 
        if (e instanceof IOException) 
            throw (IOException) e;
        throw new IOException("Unable to load Algo", e);
    }