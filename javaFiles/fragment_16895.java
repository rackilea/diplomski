import java.util.*;
public class Moviesol{
public static void main (String[] args){
Scanner sc= new Scanner(System.in);
Movie[] m = new Movie[3];
for(int i=0;i<3;i++){
    String name =sc.nextLine();

    String company =sc.nextLine();

    String genre =sc.nextLine();

    String strBudget =sc.nextLine();
    Long budget = null;
    try {
        budget = Long.parseLong(strBudget);
    } catch (NumberFormatException ex) {
        // what happens if they didn't enter a number
    }
    m[i] = new Movie(name, company, genre, budget);
}

String ip = sc.nextLine();

MovieByGenre(m , ip);