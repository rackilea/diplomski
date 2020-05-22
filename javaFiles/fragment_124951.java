import org.stringtemplate.v4.*;
import java.util.*;

public class T {
    public static class User {
    public int id;
    public String name;
    public User(int id, String name) {
        this.id= id;
        this.name = name;
    }   
    }   
    private static String stringTemplate = "Hello, my name is <name>,"
    + "<users:{x| - <x.id> - <x.name>}> ";
    public static void main(String[] args) {
    ST st = new ST(stringTemplate);
    List<User> users = new ArrayList<User>();
        for (int i=1; i<=5; i++) {
        users.add(new User(i, "bob"+i));
        }   
    st.add("users", users);
    st.add("name", "tjp");

        long start = System.currentTimeMillis();
        for (int n = 0; n < 1000000; n ++) {
            st.render();
        }   
        long end = System.currentTimeMillis();
    System.out.printf("%d ms\n", end-start);
    }   
}