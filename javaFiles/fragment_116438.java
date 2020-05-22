import java.util.Scanner;
public class HelloChess{
    static String fullChessBoard[][] = {
        {"Rb1", "Kb1", "Bb1", "Qb1", "Ab1", "Bb2", "Kb2", "Rb2"},
        {"Pb1", "Pb2", "Pb3", "Pb4", "Pb5", "Pb6", "Pb7", "Pb8"},
        {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
        {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
        {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
        {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
        {"Pw1", "Pw2", "Pw3", "Pw4", "Pw5", "Pw6", "Pw7", "Pw8"},
        {"Rw1", "Kw1", "Bw1", "Qw1", "Aw1", "Bw2", "Kw2", "Rw2"},
        };

    public static void main(String []args){
        Scanner scan = new Scanner(System.in); 
        System.out.print("Enter Row: ");            
        int row = scan.nextInt();
        System.out.print("Enter Column: ");
        int column = scan.nextInt();
        System.out.println("Result : "+fullChessBoard[row][column]);
        scan.close();
    }
}