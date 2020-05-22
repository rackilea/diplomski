import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonTest {   
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("data.txt");
        Scanner sc = new Scanner(inputFile);

        ArrayList<Person> peopleList = new ArrayList<Person>();
        Person p;

        while (sc.hasNext()){
            p = new Person();
            p.setName(sc.nextLine());
            System.out.println(p.getName());
            p.setGender(sc.nextLine());
            System.out.println(p.getGender());
            p.setAge(Integer.parseInt(sc.nextLine()));
            System.out.println(p.getAge());
            p.setWeight(Double.parseDouble(sc.nextLine()));
            System.out.println(p.getWeight());
            peopleList.add(p);
        }

        sc.close();
    }
}