public class Main {

        public static void main(String[] args)
        {
            int[] a = new int[]{1,2,12,2,3,4,5,6,7,8,9,7,123};
            int[] b = new int[]{2,1,3,6,4,5,8,9,12};



            for (int i=0;i<a.length;i++)
            {
             int count =0;
             for (int j=0;j<b.length;j++)
             {
                if(b[j]==a[i])count++;
             }
              if (count==0 && !visitedPreviously(i-1, a[i], arr)) System.out.print(a[i] + " ");
            }
        }

    private boolean visitedPreviously(int index, int val, int[] arr){
         while(index >= 0){
              if(val == arr[index]){
                 return true; 
              }
           index--;
         }
      return false;

    }

    }