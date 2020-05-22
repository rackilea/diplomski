import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Arrays;
    import java.util.Set;


    public class Main {

        public static void main(String[] args) {
            //Array
            int Numbers[] = new int[10];
            Set<Integer> integerSet = new HashSet<>();
            Scanner Numb = new Scanner(System.in);
            for(int i=0; i < Numbers.length; i++){
                System.out.print("Enter an integer: ");
                //Stores it, and moves to the next line
                Numbers[i]= Numb.nextInt();

                //Removes duplicates
                //Code to remove duplicates goes here VVVV
                integerSet.add(new Integer(Numbers[i]));

                if(i == Numbers.length) {
                    break;
                }

            }
            System.out.println("The number of distinct values is  " + Arrays.toString(integerSet.toArray()));

        }

    }