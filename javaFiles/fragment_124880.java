import java.util.Scanner;
import java.util.Arrays;
public class Interface {

    public static void main(String[]args)
    {
        Scanner in=new Scanner(System.in);
        Information input2 = new Information();
        int x=1;
        while(x!=0)
        {

        System.out.println(" \n[1] Add new student member. \n[2] View members.\nChoose now: ");
        int choose = in.nextInt();

        switch (choose){

            case 1:
              IT_Members input1 = new IT_Members();// this need to be here so that every time crete new object
              System.out.println("Name: ");
              input1.setName(in.nextLine());
              System.out.println("Deparment: ");
              input1.setDeparment(in.nextLine());
              System.out.println("Postion: ");
              input1.setPostion(in.nextLine());
              input2.Add(input1); // that was missing
              System.out.println("Student record has been added. ");
              break;

            case 2:

                input2.Display();
                break;

}
}