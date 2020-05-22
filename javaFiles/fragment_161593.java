class ClassA {

    String whoAmI() {
        return "ClassA";
    }
} 

class Main {

    public static void main(String[] args) {

        Object obj1 = new ClassA();
        obj1.whoAmI(); 
    }   
}