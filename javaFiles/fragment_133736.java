import java.util.ArrayList;

    public class ArrayListPractice {

        public static ArrayList<Integer> x = new ArrayList<Integer>(); 

        static {
                x.add(0);
                x.add(50);
                x.add(100);
        }
        static void printSecondElement(){
            System.out.println(x.get(1));
        }

         public static void main(String args[]){


             System.out.println(x);
             printSecondElement();
         }

    }