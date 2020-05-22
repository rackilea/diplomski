myMultiArr = new int[in.readInt()][];
 for(int iter = 0 ; iter < myMultiArr.length ; iter++) {
      myMultiArr[iter] = new int[in.readInt()];
      for(int i = 0 ; i < myMultiArr[iter].length ; i++) {
          myMultiArr[iter][i] = in.readInt();
      }
 }