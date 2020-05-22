import java.util.Scanner;
public class triangle{
  public static void main(String[] args){
    int R;
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    R = sc.nextInt();
    int k = R;
    for(int i=0; i<R; i++){
      for(int j=k; j>0; j--){
        System.out.print('$');
      }
      k = k - 1;
      System.out.print('\n');
    }
  }
}