public static void main(String args[]) {        
    Dog dog = new Dog();
    makeMeTalk(dog);
}

public static void makeMeTalk(Animal animal) {
    animal.talk();
}