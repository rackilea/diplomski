package myfolder;

public class Foo {
    public static void bar(String... args) {
        for(String s : args)
            System.out.println(s);
    }
}