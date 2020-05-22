import java.util.Arrays; 
public class BattleshipGrid {
    private static char[][] arr1 = new char[10][10]; // Made it static so that
         // it would be bound to the class object itself, so that you can see
         // it from the main method which is also static and bound to the class
         // object
    private static char[][] arr2 = new char[10][10];
    private static char[][] arr3 = new char[10][10]; 
    private static char[][] arr4 = new char[10][10];

    public static void main (String[] args) {
        for (char[] i: arr2) {
            for(char j: i) {
                i[j]='X';
            }
        }

    }
}