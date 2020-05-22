// Dog.java
class Bone {
    private String name;
    Bone( String name ){
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}
class Dog {
    int legs; 
    Bone chewy; 
    Bone squeeky; 

    public Dog (Bone chewyO, Bone squeekyO) { 
        this.legs = 4; 
        this.chewy = chewyO;
        this.squeeky = squeekyO; 
    } 
    public String toString() {
        return String.format("This dogs has: %d legs, and two bones: %s, %s", legs, chewy, squeeky );
    }
    public static void main( String [] args ) {
        Bone a = new Bone("chewy");
        Bone b = new Bone("squeeky");
        Dog dog = new Dog( a, b );
        System.out.println( dog );
    }
 }
 $javac Dog.java
 $java Dog
 This dogs has: 4 legs, and two bones: chewy, squeeky