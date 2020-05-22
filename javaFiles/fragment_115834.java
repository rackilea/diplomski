import java.util.*;
public class Dogprint2 {
    public static void main(String[] args) {

        Dog doggy = new Dog();
        doggy.setbreed("Alsation");
        doggy.setsize(5);

        ArrayList<Dog> dog2 = new ArrayList<Dog>();

        dog2.add(doggy);

        for (Dog d : dog2) {
            System.out.println(d.getsize());
            System.out.println(d.getbreed());
            if (d.getsize() == 5) {
                d.bark();
            }
        }       
    }
}