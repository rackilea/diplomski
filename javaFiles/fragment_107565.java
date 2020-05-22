import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.File;

@Root(strict = false)
public class Account {

    @Element
    @Path("results/account")
    String creationTimestamp;

    @Element
    @Path("results/account")
    Category category;

    public static void main(String[] args)
            throws Exception
    {
        Account account = new Persister().read(Account.class, new File("example.xml"));

        System.out.println(account.creationTimestamp);
        System.out.println(account.category.type);
        System.out.println(account.category.name);
    }
}

@Root
class Category {

    @Element
    String type;

    @Element
    String name;
}