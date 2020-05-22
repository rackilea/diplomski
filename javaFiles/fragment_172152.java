public class AsCaller {
    String name;
    int id;



    void intinit(int age, int marks){
        System.out.println("int datatype invoked");
    }
    void floatinit(String city, String street, float house){
        System.out.println("float datatype invoked");
    }
    AsCaller(String city, String street, float house) {
        floatinit(city,street,house);
    }

    AsCaller(int age, int marks) {
        intinit(age,marks);
    }

    AsCaller(String n, int i) {
      // How to use this() keyword to invoke any of the above constructor?.
        this();
        intinit(1,2);
        floatinit("a","b",3.0f);
        name = n;
        id = i;
    }

    AsCaller() {
        System.out.println("No arguments");
    }
    void display() {
        System.out.println(id + " " +name);
    }

    public static void main(String[] args) {
        AsCaller example1 = new AsCaller("Student", 876);

        example1.display();
    }  
    }