import java.io.IOException;

public class Test {
static private int startKeyIndex = 0;


private static void extractIndexes(String content) throws IOException {
    startKeyIndex = 10;
    System.out.println(startKeyIndex);
}                   


private static void extractKeywords(String pattern, String content) throws 
                                                                IOException{   
    System.out.println(startKeyIndex);
}


public static void main(String[] args) throws IOException {
    extractIndexes("");
    extractKeywords("", "");
}


}