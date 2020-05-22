import java.net.*;

    class NetTest {

    public static void main(String[] args) throws Exception{

        URL url;

        url = new URL(new URL(new URL("http://example.com/wow/"), "2/"), "3");
        // --------------------------------------------------^------^

        System.out.println(url);
    }

}