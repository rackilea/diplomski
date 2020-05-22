package recursivesearch;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Recursion {

    public static ArrayList<Point> searched = new ArrayList<Point>();
    public static ArrayList<Point> groupOrigins = new ArrayList<Point>();
    public static int groups = 0;
    public static boolean finished = false;
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public static HashMap<Character, Integer> groupCount = new HashMap<Character, Integer>();
    public static char largestChar;
    public static int largestInt = 0;
    public static int largestIndex = 0;

    public static void main(String[] args) throws FileNotFoundException {
        final File inputFile = new File(args[0]);
        final Scanner input = new Scanner(inputFile);
        char[][] grid = new char[10][20];

        // Creates the 2d array
        for (int row = 0; row < 10; row++) {
            String c = input.nextLine();
            for (int col = 0; col < 20; col++) {
                grid[row][col] = c.charAt(col);
            }
        }
        numbers.add(0);
        display(grid);
        search(grid);
        // System.out.println("NUMBER SIZE"+numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            // System.out.println("NUmber is "+numbers.get(i));
            if (numbers.get(i) > largestInt) {
                largestInt = numbers.get(i);
                largestIndex = i;
            }
        }
        // System.out.println("INDEX IS "+ largestIndex);
        // System.out.println("Groups" + groups);
        // for(Point i :searched)
        // {
        // System.out.println("Searched" +i.toString());
        // }

        // System.out.println(map.toString());
        getLargest();
        /*
         * for(int i = 0;i<groupOrigins.size();i++) {
         * System.out.println("Group origin for group "+i +": "+
         * groupOrigins.get(i)); }
         */
        System.out.print("Largest Group is " + largestChar + " with "
                + largestInt + " members starting at ("
                + (int) groupOrigins.get(largestIndex).getX() + ","
                + (int) groupOrigins.get(largestIndex).getY() + ") "
                + "Group Counts:");
        java.util.Iterator<Entry<Character, Integer>> it = groupCount
                .entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pairs = (Map.Entry<Character, Integer>) it
                    .next();
            System.out.print(pairs.getKey() + " = ");
            System.out.print(pairs.getValue());
            System.out.print(pairs.getValue() > 1 ? " Groups" : "Group");
            if (it.hasNext()) {
                System.out.print(",");
            }

            it.remove();
        }
        input.close();
    }

    public static void getLargest() {
        largestInt = 0;
        java.util.Iterator<Entry<Character, Integer>> it = map.entrySet()
                .iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pairs = (Map.Entry<Character, Integer>) it
                    .next();
            if (pairs.getValue() > largestInt) {
                largestChar = pairs.getKey();
                largestInt = pairs.getValue();
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        // System.out.println("Largest Char is " + largestChar);
        // System.out.println(largestInt);

    }

    // method to display the input file. Assuming no grid is no more than 10
    // rows
    private static void display(char[][] grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void search(char[][] grid) {
        search(grid, 0, 0);

    }

    private static void search(char[][] grid, int x, int y) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                search(grid, i, j, grid[i][j]);
            }
        }

    }

    private static void search(char[][] grid, int x, int y, char c) {

        search(grid, x, y, c, groups);
        if (finished == true) {
            // System.out.println("GROUP " + groups + " with Character " + c +
            // " has members of : " + numbers.get(groups));
            if (!map.containsKey(c)) {
                map.put(c, -1);
                groupCount.put(c, 1);
            } else {
                groupCount.put(c, groupCount.get(c) + 1);
            }
            if (map.get(c) < numbers.get(groups)) {
                // System.out.println("OVERWRITE");
                map.put(c, numbers.get(groups));
            }
            groups++;
            finished = false;
        }

    }

    private static void search(char[][] grid, int x, int y, char c, int group) {
        Point now = new Point(x, y);

        if (!searched.contains(now)) {
            // System.out.println(now.toString() + c);
            finished = true;
            searched.add(now);
            while (numbers.size() <= group) {

                numbers.add(0);
            }
            while (groupOrigins.size() <= group) {
                groupOrigins.add(new Point(-1, -1));
            }
            if (groupOrigins.get(group).equals(new Point(-1, -1))) {
                groupOrigins.set(group, now);
            }

            numbers.set(group, numbers.get(group) + 1);
            if (y - 1 >= 0) {
                if (grid[x][y - 1] == c) {
                    search(grid, x, y - 1, c, group);
                }
            }
            if (y + 1 < 20) {

                if (grid[x][y + 1] == c) {
                    search(grid, x, y + 1, c, group);
                }
            }
            if (x - 1 >= 0) {
                if (grid[x - 1][y] == c) {
                    search(grid, x - 1, y, c, group);
                }
            }
            if (x + 1 < 10) {
                if (grid[x + 1][y] == c) {
                    search(grid, x + 1, y, c, group);
                }
            }
        }
    }

}