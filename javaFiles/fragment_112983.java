package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class temp {
    private static final char PLACEHOLDER = '@';

    public static void main(String[] args) throws Exception {
        String input = "";
        File file = new File("test.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            input = br.readLine();
        }
        int row = 20, column = 45;
        char[][] array = new char[row][column];
        // option 1
        //firstFillWithPlaceholders(input, row, column, array);
        // option 2
        //firstFillWithData(input, row, column, array);
        // print method for options 1 & 2
        //printArray(row, column, array);
        // option 3
        My2DArray<Character> myClass = useOop(input, row, column);
        // print method for option 3
        System.out.println(myClass);
    }

    private static My2DArray<Character> useOop(String input, int row, int column) {
        My2DArray<Character> result = new My2DArray<Character>(row, column, PLACEHOLDER);
        int offset = 0;
        for (int i = 0; i < row && offset < input.length(); i++) {
            for (int j = 0; j < column && offset < input.length(); j++) {
                result.set(i, j, input.charAt(offset++));
            }
        }
        return result;
    }

    private static void firstFillWithData(String input, int row, int column, char[][] array) {
        int offset = 0;
        offset = writeData(input, row, column, offset, array);
        fillTheRestWithPlaceholders(row, column, offset, array);
    }

    private static void fillTheRestWithPlaceholders(int row, int column, int offset, char[][] array) {
        for (int i = offset / column; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i*column + j >= offset) {
                    array[i][j] = PLACEHOLDER;
                }
            }
        }
    }

    private static void firstFillWithPlaceholders(String input, int row, int column, char[][] array) {
        int offset = 0;
        fillWithPlaceHolders(row, column, array);
        offset = writeData(input, row, column, offset, array);
    }

    private static void fillWithPlaceHolders(int row, int column, char[][] array) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = PLACEHOLDER;
            }
        }
    }

    private static int writeData(String input, int row, int column, int offset, char[][] array) {
        for (int i = 0; i < row && offset < input.length(); i++) {
            for (int j = 0; j < column && offset < input.length(); j++) {
                array[i][j] = input.charAt(offset++);
            }
        }
        return offset;
    }

    private static void printArray(int row, int column, char[][] array) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}