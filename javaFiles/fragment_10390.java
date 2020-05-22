Import java.util.Scanner;
public class PerfectSquares {

public void numberInput(int max){
    List<Integer> squares = new ArrayList<>();
    for(int i =0;i<max;i++) {
        squares.add(i^2);
    }
    System.out.println("The squares are: " +  String.join(squares, ", ");
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number");
    int choice = sc.nextInt();
    PerfectSquares input = new PerfectSquares();
    input.numberInput(choice);
}