package _testing;

import java.util.Date;

public class Speed {

    long count = 5000000;
    public static void main(String[] args) {

        long start, finish; 
        Speed sp = new Speed(); 

        start = new Date().getTime();
        sp.test("test");
        finish = new Date().getTime();
        System.out.println("test 1:"+(finish - start));

        start = new Date().getTime();
        sp.test2("test");
        finish = new Date().getTime();
        System.out.println("test 2:"+(finish - start));

    }


    public void test(String str) {
        int len = str.length();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a = a + len;
        }
    }

    public void test2(String str) {
        int a = 0;
        for (int i = 0; i < count; i++) {
            a = a + str.length();
        }
    }   
}