import java.util.*;
import java.util.stream.*;

public class Test {

    public static void generateCombinations(ArrayList <String> strings, String delimiter){

        int stringsSize = strings.size();
        int i=0;
        String text = "";
        parseList(text, stringsSize ,i, strings, delimiter);

    }

    public static void parseList(String text, int stringsSize, int i,    ArrayList <String> strings, String delimiter) {
        String stringStream = strings.get(i);
        String[] list = stringStream.split(delimiter);
        if (i==stringsSize-1) {
            for (String string : list){
                System.out.println(text + " " + string.replaceAll("\\s+",""));
            }
        } else {
            for (String string : list){
                String text2 = text + " " + string.replaceAll("\\s+","");
                int j = i+1;
                parseList(text2, stringsSize, j, strings, delimiter);
            }
        }
    }

    public static void main(String[] args) {    
        ArrayList <String> strings = new ArrayList <String>();
        strings.add("slow,steady");
        strings.add("blue, white, green");
        strings.add("whale, shark ");

        generateCombinations(strings , ",");  

    }  
}