public static void sort( int[] arr, int min, int max )
{
  int nBuckets = max - min + 1;
  int [] bucket=new int[nBuckets];
  for (int i=0; i< arr.length; i++) {
       bucket[arr[i] - min]++;

  }
  int index = 0;
  for (int i=0; i<bucket.length; i++) {
      for (int j =0; j<bucket[i]; j++) {
          arr[index++]=min;
      }
      min++;
  }
}