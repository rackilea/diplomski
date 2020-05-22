//Your method:
public static int test(int arr[], int x, int y){
   x = y;
   arr[y] = 1;
   return y;
}

//main method:
public static void main(String[] args){
   int[] someArray = {1, 2, 5, 12, 2};
   test(someArray, 4, 5);
}