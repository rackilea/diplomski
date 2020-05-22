public class positiveNumber{

 public static void main(String[] args){
      int n= taking Input from user;
      List<Integer> listOfNumbers=new ArrayList<Integer>();
   for(int i = 0 ; i< n ; i++){
          listOfNumbers.add(i);
          printListInReverse(listOfNumbers);
   }
}
public static void printListInReverse(List<Integer>listOfNumbers){
       List temp = new ArrayList(listOfNumbers);
       Collections.reverse(temp);
       System.out.println(temp); //either iterate the list or print in once
}
}