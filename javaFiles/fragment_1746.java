public int[] make2(int[] a, int[] b) {
      List<Integer> answers = new ArrayList<Integer>();
      for(int x = 0; x <= 1; x++){    
          if(a[x] != 0) {             
              answers.add(a[x]);
          } else if (b[x] != 0) {
              answers.add(b[x]);
          }
      }
}