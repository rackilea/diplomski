import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Sort implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final File file = new File("sort.txt");

    public static void main(String args[]) throws Exception {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String sCurrentLine;
        String[] array = null;

        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println("enter how many numbers you need to sort");
        int n = sc.nextInt();
        int[] al = new int[n];
        try (FileWriter fw = new FileWriter(file);) {
            for (int k = 0; k < al.length; k++) {
                fw.write(new Integer(rand.nextInt(10)).toString());
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((sCurrentLine = br.readLine()) != null) {
                array = sCurrentLine.toString().split("");
            }
            for (int counter = 0; counter < array.length; counter++) {
                System.out.println(array[counter]);
            }
        }
        sc.close();
    }
}