package com.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {
        double newmanUtil = 1;
        double yandi1Util = 3;
        double yandi2Util = 2;
        double miningAreaCUtil = 4;

        List<Double> items = new ArrayList<Double>();
        items.add(newmanUtil);
        items.add(yandi1Util);
        items.add(yandi2Util);
        items.add(miningAreaCUtil);

        Collections.sort(items);

        System.out.println(items);
    }
}