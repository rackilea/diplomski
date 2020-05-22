import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) {

        File k = new File("program7b.txt");
        try {
            Scanner scanner = new Scanner(k);

            ArrayList<User> users = new ArrayList<User>();


            while (scanner.hasNext()) {
                int id = Integer.parseInt(scanner.next());
                users.add(new User(id));
            }

            System.out.println("Unsorted: ");

            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getId());
            }

            Collections.sort(users);

            System.out.println("Sorted: ");
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getId());
            }

            scanner.close();
        } catch (FileNotFoundException ex) { 
            System.out.println(ex.getMessage());
        }
    }
}

class User implements Comparable<User> {
    private int id;

    public int getId() {
        return id;
    }

    public User(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(User user) {        
        if(id < user.getId())
            return -1;
        if(id == user.getId())
            return 0; 
        else return 1;
    }

    @Override
    public String toString() {        
        return "user id: " + id;
    }
}