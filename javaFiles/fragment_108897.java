maxMiles = milesTracker[0][0];

    minMiles = milesTracker[0][0];

for(i=0;i<NUM_ROWS;++i){
         for(j=0;j<NUM_COLS;++j){
             if (milesTracker[i][j]<minMiles){
               minMiles = milesTracker[i][j];
            }
             else if (milesTracker[i][j] > maxMiles){
               maxMiles = milesTracker[i][j];
            }
         } 
      }