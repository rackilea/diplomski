import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
public static void main (String[] args) throws java.io.IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    //int n;
    boolean whatever  = true;

    while(whatever){
            System.out.println("If you would like to type something w/o using the formula, type 1");
            System.out.println("If you would like to type something using the formula, type 2");
            System.out.println("If you would like to quit, type 0");

            str = br.readLine();


            if(Integer.parseInt(str)==1){
                System.out.println("Type something below and press enter to end your input");
                String str1 = br.readLine();
                System.out.println("Your word is " + str1);
                System.out.println("Your altered word is: ");

              str1 = str1.replace('A', 'Q');
                str1 = str1.replace('E', 'W');
                 str1 = str1.replace('I', 'L');
                 str1 = str1.replace('O', 'P');
                str1 = str1.replace('U', 'G');
                str1 = str1.replace('1', 'J');
        //str = s7r.replace(‘J uuuuu’, ‘1’);
                 str1 = str1.replace('5', 'S');
                 str1 = str1.replace('S', '5');
                str1 = str1.replace('8', 'B');
                str1 = str1.replace('B', '8');

                System.out.println(str1);

            }

            else if(Integer.parseInt(str)==2){
                System.out.println("Type something below and type '/.' to end your input");
                str = br.readLine();

                System.out.println("Your word is " + str);
                System.out.println("Your decoded word is: ");

                str= str.replace('Q', 'A');
                 str= str.replace('W', 'E');
                 str= str.replace('L', 'I');
                 str= str.replace('P', 'O');
                 str= str.replace('G', 'U');
                 str= str.replace('1', 'J');
                 str= str.replace('J', '1');
                 str= str.replace('5', 'S');
                 str= str.replace('S', '5');
                 str= str.replace('8', 'B');
                 str= str.replace('B', '8');

                System.out.println(str);
                }
            else if(Integer.parseInt(str)==0){
            System.out.println("Quit");
             whatever = true;
             break;
             }
             else{
             System.out.println("Wrong Input Try Again!");
             }


    }



  }          
}