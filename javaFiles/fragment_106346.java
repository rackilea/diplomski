import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

class Users {
    public static void main (String... args) {
        try {
            Document dom = new SAXReader().read(new File(args[0]));
            System.out.println("Root element: server\n");
            List<Node> packs = dom.selectNodes("/server/users");
            for (Node pack : packs) {
                System.out.println("Pack of users: " + pack.valueOf("@id") + "\n");
                List<Node> users = pack.selectNodes("no");
                for (Node user : users) {
                    System.out.println("Current element: no");
                    System.out.println("User no: " + user.valueOf("@id"));
                    System.out.println("Name: " + user.valueOf("name"));
                    System.out.println("E-mail: " + user.valueOf("email") + "\n");
                }
            }
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}