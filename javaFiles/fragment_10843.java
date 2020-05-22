int[] rotateArray(int n, int[] data)
 {
      if(n < 0) // rotating left?
      {
          n = -n % data.length; // convert to +ve number specifying how 
                                // many positions left to rotate & mod
          n = data.length - n;  // rotate left by n = rotate right by length - n
      }
      int[] result = new int[data.length];
      for(int i = 0; i < data.length; i++){
          result[(i+n) % data.length ] = data[i];
      }
      return result;
 }