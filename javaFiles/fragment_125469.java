import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sudoku {

    static String readFile(String path, Charset encoding) 
    throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    static int[][] parse(String path) throws IOException {
        String input = readFile(path, Charset.defaultCharset());
        int [][] array = new int[10][10];
        int x = 0;
        int y = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (chars[i] == '\n') {
                x = 0;
                y++;
                continue;
            } else if (chars[i] == '.') {
                array[y][x] = -1;
                x++;
                continue;
            }
            array[y][x] = Character.getNumericValue(chars[i]);
            x++;
        }

        return array;
    }
    public static void main(String[] args) 
        throws IOException {
        int m = 9;
        int n = 9;
        int[][] a = parse("Sudoku.txt");
        //print the input matrix
        System.out.println("The input sorted matrix is : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if (j==3 || j==6) System.out.print ("| ");
                if (a[i][j]==-1) {
                    System.out.print(". ");
                } else {
                    System.out.print(a[i][j]+" ");
                }
            }

            System.out.println("");
            if (i==2 || i==5) System.out.println("----------------------");
        }
    }
}