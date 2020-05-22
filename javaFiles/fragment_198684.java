public static void main(String args []){
    // your code here..
 } 

 public static void printUp(int[] array){
    System.out.print("Ascending");
    for(int i = 0; i < array.length; i++){
           if(array[i] > 0)
                System.out.printf("%5d\t%5d\n",i,array[i]);
    }
 }

 public static void printDown(int[] array){
     System.out.print("Descending");
     for(int i = 0; i < array.length; i--){
           if(array[i] > 0)
               System.out.printf("%5d\t%5d\n",i,array[i]);
     }
}