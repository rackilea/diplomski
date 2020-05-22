public class positiveNumber{
    static List<Integer> listOfNumbers=new ArrayList<Integer>();
    static int n;

     public static void main(String[] args){
           n= "take input fmo user"
           print(0);
    }
    /*
     *Using Recursion
     */
    public static void print(int i){
              if(i==n)
                 return;
              listOfNumbers.add(i);
              printListInReverse();
              print(i+1);
        }

    public static void printListInReverse(){
           List temp = new ArrayList(listOfNumbers);
           Collections.reverse(temp);
           System.out.println(temp); //either iterate the list or print in once
    }
    }