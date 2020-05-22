public class SO {
public static void main(String[] args) throws Exception {
    String rsp = curl("http://axrsgpar0019:13080/api-token-auth/", "application/json", "username=myusername&password=mypassword");
}
public static String curl(String url, String accepts, String minusD) throws Exception {
    HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
    con.setDoOutput(true);
    con.setRequestProperty("Accept", accepts);
    con.setRequestProperty("Content-Type",  "application/x-www-form-urlencoded");
    con.getOutputStream().write(minusD.getBytes());
    con.getOutputStream().close();

    ByteArrayOutputStream rspBuff = new ByteArrayOutputStream();
    InputStream rspStream = con.getInputStream();

    int c;
    while ((c = rspStream.read()) > 0) {
        rspBuff.write(c);
    }
    rspStream.close();

    return new String(rspBuff.toByteArray());
}
}