package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(11);
        integers.add(0, 22);
        integers.add(33);

        List<String> strings = new ArrayList<>();
        strings.add("foo");
        strings.add(0, "bar");
        strings.add("zot");
    }
}