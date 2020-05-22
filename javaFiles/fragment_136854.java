import java.util.Scanner;


public class Lab10Ex2 {

/**
 * @param args
 */
public static void main(String[] args) {
    int choice = 0;
    int[] stringArray = {};
    String[] stringarray = new String[20];

    do{         




        System.out.println("----------------MENU---------------");

        System.out.println();
        System.out.println("1. Add Students");
        System.out.println("2. Delete Students");
        System.out.println("3. Search for student");
        System.out.println("4. Print all Students");
        System.out.println("5. exit");



        Scanner scanchoice = new Scanner(System.in);
        choice = scanchoice.nextInt();

        if (choice ==1){

            Scanner scannames = new Scanner(System.in);

            System.out.println("Please enter the student names into the array");
            System.out.println();

            int i = 0;


            for(i = 0; i<stringarray.length; i++){



                String temp =scannames.nextLine();

                stringarray[i]=temp.toLowerCase();

                if(i==(stringarray.length-1)){
                    System.out.println("successfully filled up array fully");
                    System.out.println();
                }


            }







        }

        if(choice==2){


        }


        if(choice==3){


            for(int p = 0; p<stringarray.length; p++){

                System.out.println(stringarray[p]);

            }
            int x=0;
            Scanner scannames1 = new Scanner(System.in);

            System.out.println("Enter name of student you want to search for: ");
            System.out.println();
            String search=scannames1.nextLine();
            String searchName=search.toLowerCase();

            for(int p = 0; p < stringarray.length ;p++){
                if(searchName.equals(stringarray[p])){
                    x=1;
                    break;
                }
                else{
                    x=0;
                }
            }



            if(x==1){
                System.out.println("We have a match in our database for "+ searchName);
            }
            else if (x==0){
                System.out.println("No match for "+ searchName);
            }
        }





        if (choice ==4){
            System.out.println("List of names:");

            for(int p = 0; p<stringarray.length; p++){

                System.out.println(stringarray[p]);
                System.out.println();


            }

        }










    }while(choice!=5);

}

}