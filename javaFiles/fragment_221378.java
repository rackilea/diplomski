public static void main(String[] args) {
    Cat myCat = new Cat();
    System.out.println("Create a Cat instance ...");
    myCat.hide(); 
    Cat.hide();
    myCat.override();  

    Animal myAnimal = myCat;
    System.out.println("\nCast the Cat instance to Animal...");
    Animal.hide();     
    myAnimal.override();

    Animal myAnimal1 = new Animal();
    System.out.println("\nCreate an Animal instance....");
    Animal.hide();     
    myAnimal.override();
}