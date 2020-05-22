package test;

import java.util.stream.Stream;


public class Test {

    public static void main(String[] args) {
        Stream.of(args)
                .forEach(arg -> System.out.println("ARGUMENT " + arg));
    }
}