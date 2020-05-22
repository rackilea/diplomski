public class MainClass{
    public static void main(String[]args){
         MethodsForArray myObject=new MethodsForArray();
         myObject.numbers=new int[]{1,3,4};
         myObject.printOutArray();    //Here i apply the method
     }
}

class MethodsForArray{
    int numbers[];

        public void printOutArray(){
            for (int i=0; i<numbers.length; i++){
                System.out.print(numbers[i]);
            }
        }
}