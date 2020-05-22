.....

 for (j = 0; j < NUM_COLS; j++) {
          if (i == 0 && j == 0) {
              minMiles = milesTracker[i][j];
              maxMiles = milesTracker[i][j];
          }
         if (milesTracker[i][j] > maxMiles){
                  maxMiles = milesTracker[i][j];
          }else if(milesTracker[i][j] < minMiles ){
                    minMiles = milesTracker[i][j];
          }

      }

.....