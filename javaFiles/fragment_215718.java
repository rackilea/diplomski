public class Vehicle {
int maxSpeed;
int wheels;
String color;
double fuelCapacity;

void horn(String in) {
    System.out.println(in);
}

void blink() {
    System.out.println("I'm blinking!");
}
}

class MyClass {
public static void main(String[ ] args) {
    String a = "Beep!";
    String b = "Boop!"; 

    Vehicle v1 = new Vehicle();
    Vehicle v2 = new Vehicle();
    v1.color = "red";
    v2.horn(a);
    v1.blink();
    }
}