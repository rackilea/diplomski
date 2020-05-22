void something(int parameter) {
     if(parameter < 0) {
         for(int i = 0; i < 4; i++) {
             work[0][findPlace(parameter)].countUp();
             work[findPlace(parameter)][0].countUp();
         }
     } else {
         for(int i = 0; i < 4; i++) {
             something(parameter - 1);
             work[0][findNextPlace(parameter)].countUp();
             work[findNextPlace(parameter)][0].countUp();
         }
     }
 }