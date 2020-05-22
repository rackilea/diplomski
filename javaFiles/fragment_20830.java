import java.util.Arrays;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class Main
{
    public static void main(String[] args) {

        User[] users = {new User(2, "user2"), new User(1, "user1"), new User(3, "user3")};

        Arrays.sort(users); 

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getUsername());
        }

    }
}

 class User implements Comparable<User> {

    private int id;
    private String username;


    public String getUsername() {
        return username;    
    }

    public int getId() {
        return id;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public int compareTo(User user) {        
        if(id < user.getId())
            return -1;
        if(id == user.getId())
            return 0; 
        else return 1;
    }
}