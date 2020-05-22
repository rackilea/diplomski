public static int[] make2(int[] a, int[] b) {
      int[] answer = new int[2];
      for(int x = 0; x <= 1; x++){
          if(a.length >= x && a[x] != 0) { 
              answer[x] = a[x];
          } else if (b.length >= x && b[x] != 0){
              answer[x] = b[x];
          }
          // optional
          else {
              answer[x] = -1; // this tells you there's no valid element!
          }
      }
      return answer;
}