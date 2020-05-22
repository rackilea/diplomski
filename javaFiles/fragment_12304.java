public class Animal {

public String name; //not static!Static means that one variable is shared among all instances of a class, which is not what you want here presumably
public String species;
public int age;

public Animal(String name, String species, int age) { //this is okay
    this.name=name;
    this.species=species;
    this.age=age;
}
public static void main(String[]args){
Animal thisAnimal = new Animal("Hungry Hippo", "Hippopotamus", 5);

//thisAnimal is an INSTANCE of the animal class, and will be created when you run the program. (whatever is in your main method is what gets run.) 
}
}