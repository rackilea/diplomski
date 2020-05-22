package eg;

import egPriv.PrivCat;

import java.io.IOException;

public class Cat extends PrivCat {
    public static void main(String[] args) throws IOException {
        Cat eg2 = new Cat();
        System.out.println("Processing with privilege:");
        eg2.catPriv(args[0]);

        System.out.println("Processing normally");
        eg2.cat(args[0]);
    }
}