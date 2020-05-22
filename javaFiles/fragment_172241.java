package test;

import test.Test1.Test3;

public class Maker {

    public static void main(String[] args) {
    Test1 test1 = new Test1();
        Test3 test3 = test1.new Test3();    
    }

}