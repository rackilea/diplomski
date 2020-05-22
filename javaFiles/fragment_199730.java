class Flavor1Demo {

// An anonymous class with Demo as base class
Demo d = new Demo() {
    void show() {
        super.show();
        System.out.println("i am in Flavor1Demo class");
    }
};

public static void main(String[] args) {

    Flavor1Demo flavor1Demo =  new Flavor1Demo();
    flavor1Demo.d.show();
}
}