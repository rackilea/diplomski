public class Main  {
      static int x=0;
public static void find(int a, int b, int [][] myArray) throws InterruptedException 
{
    System.out.println("thisWay " + a + " ");
    if (myArray.length>a&&(myArray[0].length>b&&myArray[1].length>b&&myArray[2].length>b)&&myArray[a][b] != 0&&x<100) 
    {
            x++;
        int point = myArray[a][b];
        find(a, point, myArray);
        System.out.print("thisWay " + point + " ");
        find(point, b, myArray);
    }else{
    System.out.print("thisWay " + b + " ");
    }
}
public static void main(String[] args) throws InterruptedException 
{   
    int[][] myArray = new int[][]
    {
       {7, 0, 0, 8, 7, 8, 3, 0, 7},
       {7, 0, 7, 0, 7, 8, 0, 2, 7},
       {0, 4, 5, 1, 1, 8, 0, 1, 5},
    };
    System.out.println(myArray.length);
    find(1, 2, myArray);
}
}