interface DogLike {
    void bark();
}

interface CatLike {
    void meow();
}

class Dog implements DogLike {
    @Override
    public void bark() {
        System.out.println("Woof");
    }
}

interface MoreauMachine {
    <H extends DogLike & CatLike > H createHybrid();
}

class MalfunctioningDogCatFactory implements MoreauMachine {

    @Override
    public DogLike createHybrid() {
        //Compile with -Xlint:unchecked to see a warning here:
        //Warning:(84, 20) java: createHybrid() in org.cumberlw.viewtest.MalfunctioningDogCatFactory implements <H>createHybrid() in org.cumberlw.viewtest.MoreauMachine
        //return type requires unchecked conversion from org.cumberlw.viewtest.DogLike to H
        return new Dog();
    }

    public static void main(String[] args) {
        MoreauMachine factory = new MalfunctioningDogCatFactory();

        //crashes!
        //Exception in thread "main" java.lang.ClassCastException: org.cumberlw.viewtest.Dog cannot be cast to org.cumberlw.viewtest.CatLike
        factory.createHybrid().meow();
    }
}