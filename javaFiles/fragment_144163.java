void recursive(int depth, .. parameters) {
     if (depth > CUT_OFF)
       return;
     ..        
     recursive(depth+1, parameters1);
     recursive(depth+1, parameters2);
   }