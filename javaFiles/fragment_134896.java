public class Example{

 public static void main(String []args){
     String str = "2 1";
     // first split the original string on a comma
     String[] str_arr = str.split(",");
     // if the length is one then there were no commas in the input, so split again on white space
     if (str_arr.length == 1){
         str_arr = str.split(" ");
     } 
     int[] int_arr = new int[str_arr.length];
     // assign the string array to an int array
     for (int i = 0; i < str_arr.length; i++){
         int_arr[i] = Integer.parseInt(str_arr[i]);
     }
    // output to console         
     for (int j : int_arr){
         System.out.println(j);
     }

 }
}