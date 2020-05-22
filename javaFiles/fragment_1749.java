public int[] make2(int[] a, int[] b) {
  int[] answer = new int[2];       // create the array to fill
  int y = 0;                       // create a variable to check SECOND array position
  for(int x = 0; x <= 1; x++){     // make 2 iterations
      if(a.length > x) {           // if ARRAY a has a possible value at POSITION x
          answer[x] = a[x];        // put this value into answer
      } else if (b.length > y){    // if ARRAY a does not have possible value at POSITION x, 
                                   // check if ARRAY b has some possible value at POSITION y 
                                   // (remember y is the variable that keeps position of ARRAY b)
          answer[x] = b[y++];      // put b value at answer
      }
  }
  return answer;                   // return answer
}