public class truefalse {

    public static void main(String[] args){
      int nums[][] = new int[5][5];
      for (int i=0; i<5; i++){
          for (int j=0;j<5; j++){
              if(j!=i){
                  nums[i][j]=0;
              } else if(j==i){
                  nums[i][j]=1;
              }
              System.out.print(nums[i][j]);
           }
         System.out.println();
      }
   }
}