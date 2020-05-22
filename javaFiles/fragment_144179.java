public class PutTest {

    public static void main(String[] args) throws Exception {
        URL u = new URL("https://api.bitbucket.org/1.0/repositories/myname/myproject/issues/1/");
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.addRequestProperty("Authorization", "Basic "+Base64.encodeToString(("user:password").getBytes(), false));
        c.setRequestMethod("PUT");
        c.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(c.getOutputStream());
        out.write("title=hello+world");
        out.close();
        c.connect();
        System.out.println(c.getResponseCode()+" "+c.getResponseMessage());
    }
}