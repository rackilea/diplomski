public class Scratch {

public static void main(String[] args) {
    int windowSize = 2;
    String[] tokens = {"The", "quick", "brown", "fox", "jumps", "over"};
    for (int i = 0; i < tokens.length; i++) {
        for (int j = i - windowSize; j <= i + windowSize; j++) {
            if (j >= 0 && j< tokens.length && i != j) {
                System.out.println(tokens[i] + " " + tokens[j]);
            }
        }
    }
}