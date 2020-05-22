import java.util.Scanner;

public class Main {

public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   String elso = sc.nextLine();

   String masodik = sc.nextLine();

  String longestString = elso; 
  String shortestString = masodik; 
  if (shortestString.length() > longestString.length()){
    shortestString = elso;
    longestString = masodik; 
  }
  StringBuilder builderem = new StringBuilder(" ");
   for(int i = 0; i < shortestString.length(); i++){
       builderem.append(shortestString.charAt(i));
       builderem.append(longestString.charAt(i));
   }
   for(int i = shortestString.length(); i < longestString.length(); i++){
       builderem.append(longestString.charAt(i));
   }
   String alapba = builderem.toString();
   System.out.println(alapba);
}
}