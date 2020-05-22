import java.util.ArrayList;
import java.util.Collections;


class Dog implements Comparable<Dog>{
    String name;

    Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Dog o) {
        return this.name.compareTo(o.getName()); // dog name sort in ascending order 
        //return o.getName().compareTo(this.name); use this line for dog name sort in descending order 
    }

    @Override
    public String toString() {
        return this.name;
    }
}


public class DogSort {

    public static void main(String[] args) {
        ArrayList<Dog> listDog = new ArrayList<Dog>();
        listDog.add(new Dog("doggy"));
        listDog.add(new Dog("aaa"));
        listDog.add(new Dog("bbb"));
        System.out.println(listDog);
        Collections.sort(listDog);
        System.out.println(listDog);

    }

}