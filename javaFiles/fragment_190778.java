import java.util.Scanner;


public class Main {
  public static void main(String[] args)throws Exception{

     Scanner in = new Scanner(System.in);

    int T = in.nextInt();

    for(int t = 1; t <= T; t++) {
      int first = in.nextInt();
       int second = in.nextInt();
       int result = first + second;
       System.out.println(result);
    }

 }
}