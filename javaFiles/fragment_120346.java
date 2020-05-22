import java.util.Arrays;
import java.util.Scanner;

public class Bug {

        public static void main(String[] args) {
            String strArray[]=new String[4];
            char chrArray[]=new char[4];
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the words :");
            for(int i=0;i<strArray.length;i++){
                strArray[i]=input.next();

            }
            System.out.println("Enter the Characters :");
            for (int i = 0; i < chrArray.length; i++) {
                chrArray[i]=input.next().charAt(0);

            }
            Arrays.sort(chrArray);

            for (int i = 0; i < strArray.length; i++) {
                char[] x = strArray[i].toCharArray();
                Arrays.sort(x);
                if(Arrays.equals(chrArray, x))
                {
                    System.out.println(strArray[i]);
                    break;
                }
            }
        }

 }