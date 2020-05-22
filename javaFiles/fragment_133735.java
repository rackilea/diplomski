import java.util.ArrayList;

    public class ArrayListPractice {

        public static ArrayList<Integer> x = new ArrayList<Integer>(); 
        static void printSecondElement(){
            System.out.println(x.get(1));
        }

         public static void main(String args[]){

                x.add(0);
                x.add(50);
                x.add(100);
             System.out.println(x);
             printSecondElement();
         }

    }