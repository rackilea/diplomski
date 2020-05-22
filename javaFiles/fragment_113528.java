class Animal{

}

class Mammal extends Animal{
    Mammal(int x){ 

    }
}

class Dog extends Mammal{
    Dog(){
        super(24) ;
    }

    Dog(int x){
       super(x) ;
    }
}

class BullDog extends Dog{
    BullDog(){
        this(24) ;
    }

    BullDog(int x){
        super(x) ;
    }
}