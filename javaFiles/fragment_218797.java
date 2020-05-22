package jsouptest;

    import org.jsoup.Connection;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;

    public class JsouptTest {
        public static void main(String[] args) throws Exception {

           Connection.Response loginForm = Jsoup.connect("https://www.desco.org.bd/ebill/login.php")
            .method(Connection.Method.GET)
            .execute();

           Document document = Jsoup.connect("https://www.desco.org.bd/ebill/authentication.php")
            .data("cookieexists", "false")
            .data("username", "32007702")
            .data("login", "Login")
            .cookies(loginForm.cookies())
            .post();
           System.out.println(document);

       }

    }