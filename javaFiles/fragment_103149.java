public static boolean isGameOver(int limit, int[] data){
      for(int k = 0; k < data.length; k++){
        if (data[k] < limit)
          return false;
      }
      return true;
    }