package eu.webfarmr;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10, 22, 30);

        integerList.stream().map(e -> e * 10).forEach(System.out::println);


    }
}