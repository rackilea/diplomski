package de.test.lang.stackexchange;

public class Lifts {

    public static void main(String args[]) throws Exception {
        int[] fc = new int[]{0, 6, 4, 1, 1, 2, 4, 0, 3, 1};
        int posA = 0;
        int posB = 7;

        for (int reqPos: fc) {
            final int distA = Math.abs(reqPos - posA);
            final int distB = Math.abs(reqPos - posB);

            if (distA < distB) {
                posA = reqPos;
                System.out.println("A");
            } else if (distA == distB) {
                if (posA < posB) {
                    posA = reqPos;
                    System.out.println("A");
                } else {
                    posB = reqPos;
                    System.out.println("B");
                }
            } else {
                posB = reqPos;
                System.out.println("B");
            }
        }
    }
}