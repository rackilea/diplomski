public class HttpGetWithBody extends HttpEntityEnclosingRequestBase {

    @Override
    public String getMethod() {
        return "GET";
    }
}

HttpGetWithBody getWithBody = new HttpGetWithBody ();
getWithBody.setEntity(y(new ByteArrayEntity(
            "<SOMEPAYLOAD FOR A GET ???>".toString().getBytes("UTF8"))););
getResponse = httpclient.execute(getWithBody );