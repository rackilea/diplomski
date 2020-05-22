public class Polymorphism {
    public static void main(String[] args){
        Animal obj1 = new Horse();
        Horse obj2 = new Horse();

        obj1.shout();    //output is neigh..
        obj2.shout();    //output is neigh..
        obj1.winRaces(); /*But this is not allowed and throws compile time error, 
                           even though the object is of Animal type.*/ 
    }   
}

class Animal{
    public void shout(){
        System.out.println("Parent animal's shout");
    }       
}

class Horse extends Animal{
    public void shout(){
        System.out.println("neigh..");
    }
    public void winRaces(){
        System.out.println("won race..");
    }
}