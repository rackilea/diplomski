public class MyClass{

    private int[][] myArray;
    private int myArraySize;

    public MyClass(int N){

      if(N <= 0) 
        throw new IndexOutOfBoundsException("Input Error: N <= 0");  

      myArray = new int[N][N];
      myArraySize = N;            
    }

    ...
 }