package main.java.org.example;

import java.text.DecimalFormat;
import java.util.List;

import static main.java.org.example.BetterProgrammerTask.getAverage;

public class TestBetterProgrammerTask implements BetterProgrammerTask.Node {

    public static void main(String[] args) {

        int sum = 0;
        double sumDouble = 0;
        System.out.println("EXAMPLE III");
        // get NodeImpl

        BetterProgrammerTask.Node node = new TestBetterProgrammerTask();
        sumDouble = getAverage(node);

//rest unchanged