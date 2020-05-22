import java.util.Scanner;

public class ReadArray {    
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    int count = read.nextInt();
    String arrayLine = read.next();
    int array[] = new int[count];

    String elements[] = arrayLine.split(",");
    elements[0] = elements[0].substring(1);
    elements[count-1] = elements[count-1].substring(0, elements[count-1].length()-1);
    for (int i=0; i<count; i++) {
      array[i] = Integer.parseInt(elements[i]);
    }

    for (int i : array) {
      System.out.println(i);
    }
  }
}