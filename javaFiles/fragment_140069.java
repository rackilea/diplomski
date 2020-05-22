import java.util.*;
import java.io.*;

class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> myList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("foo.txt"));
            while(in.ready()) {
                String line = in.readLine();
                String[] parts = line.split(", ");
                ArrayList<String> lineList = new ArrayList<>();
                for (String s : parts) {
                    lineList.add(s);
                }
                myList.add(lineList);
            }
        }
        catch(Exception e) {
        }

        for(ArrayList<String> elem : myList) {
            for(String item : elem) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}