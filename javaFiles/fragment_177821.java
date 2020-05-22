package main;

public class Main {

    public static void main(String[] args) {

        MyPoint p = new MyPoint();
        p.x = 5;
        System.out.println("x: "+ p.x);

    }

    private static class MyPoint {
        int x;
    }

}