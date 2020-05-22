public class Dog{
    private String name;
    private int legs = 4;

    public Dog(String name){
        this.name = name;
    }

    public int getLegs(){
        return legs; 
    }

    public int setLegs(int legs){
        this.legs = legs;
        return this.legs; 
    }

    @Override
    public String toString(){
        return "Dog is called " + name + " it has " + legs + " legs."; 
    }

    public static void main(String[] args){
        Dog dundt = new Dog("Dundt"); 
        System.out.println(dundt);
    }
}