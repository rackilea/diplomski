import java.util.Random;
 public class alpha_array
 {
     char array[][] = new char[5][5];
     Random rnd = new Random();

     public static void main(String[]args)
     {
         populate_array();
         print_array();
     }
 }