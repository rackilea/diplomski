public class MyStreamReader {

    private InputStream in;

    public MyStreamReader(InputStream in) {
        this.in = in;
    }

    public String grabString() {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        do {
            try {
                // call the readline method of the buffered reader object.
                return r.readLine();
            } catch (Exception e) {
            }
        } while (true);
    }

}