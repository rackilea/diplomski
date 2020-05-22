public class Car<T extends Material> {
    public void printName( T material ) {
        System.out.println( material.name()); 
    }
    /* ... */
}