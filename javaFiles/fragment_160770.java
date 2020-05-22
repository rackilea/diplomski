public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://localhost:4567/XXXX");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}