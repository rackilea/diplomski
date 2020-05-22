public interface Animal {

    void eat();
    void speak();
    default void sleep(){}

}