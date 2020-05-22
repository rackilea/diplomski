if(myMultiArr == null) {
     out.writeInt(0);
 } else {
     out.writeInt(myMultiArr.length);
     for(int iter = 0 ; iter < myMultiArr.length ; iter++) {
         if(myMultiArr[iter] == null) {
             out.writeInt(0);
         } else {
             out.writeInt(myMultiArr[iter].length);
             for(int i = 0 ; i < myMultiArr[iter].length ; i++) {
                 out.writeInt(myMultiArr[iter][i]);
             }
         }
     }
 }