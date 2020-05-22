public static void main(String[] args){
   int[] array = {5, 4, 3, 2, 1};
   System.out.print("results: ");
   for (int i = 0; i < array.length; i++){
       array[i] = factorial(array[i]);
       System.out.print(array[i]);
}