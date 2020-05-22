public static void main(String args[]) {

    URL url;
    InputStream is = null;
    BufferedReader br;
    String line;

    try {
        url = new URL("http://localhost/writers/");
        is = url.openStream(); // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (Exception mue) {
        mue.printStackTrace();
    } finally {
        try {
            if (is != null)
                is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }
    }

}