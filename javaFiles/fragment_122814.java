Object myGenericDog = new Dog();
Animal myAnimal = new Animal();

if(myGenericDog instanceof Animal){
    myAnimal = (Animal) myGenericDog;
}