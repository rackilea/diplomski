public class arraymin {
  public static void main(String args[])
  {
    int arr1[][]=new int[][]{{23,32,10,44},{44,33,22,11}};
    int minvalue=arr1[0][0];
    for(int i=0;i<arr1.length;i++)
    {
        for(int j=0;j<arr1[i].length;j++)
        {
            if(arr1[i][j]<minvalue)
            {
               minvalue= arr1[i][j];
            }
        } 
    }
    System.out.println("Min Value is: "+minvalue);
  }
}