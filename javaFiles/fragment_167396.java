public static int[] frequency(int[] a, int M) {
     int[] m = new int[M];
     int count;
     for(int i = 0; i < m.length; i++) {
     count =0;
     for(int j = 0; j < a.length; j++)
         if( i == a[j]){
            count++;
            m[i] = count;
         }
     }

    return m;

  }