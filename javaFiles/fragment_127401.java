public class Main {
    public static void main(String[] args){
        if(args.length !=0){
           System.out.println(args[0].length());
        }else{
          args = new String[1]; //Initilize first
          args[0] = "Hello";    //Store value in array element 
          System.out.println(args[0].length()); //Print it.
        }  
    }
}