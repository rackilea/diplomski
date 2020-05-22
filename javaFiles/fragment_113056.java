//Employee remains unchanged
public class Employee {

    public void displayMessage() {
        System.out.println("This text is defined in the second class");
    }
}


//Here you initialize a new Employee (peter in this case)
public class Person {
    public static void main(String[] args) {
        Employee peter = new Employee();
        peter.displayMessage();

    }
}