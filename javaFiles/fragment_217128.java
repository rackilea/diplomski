boolean notFound = true;

    for(int i = 0; i < 8 && notFound; i++){
        for (int l = 0; l < 8 && notFound; l++){
            if (testArray[i][l]){
                for (int k = 0; k < 8; k++){
                    testArray[i][k] = true;
                    testArray[k][l] = true;

                    if(((i - Math.min(i, l)) + k) < 8 && ((l - Math.min(i, l)) + k) < 8)
                        testArray[(i - Math.min(i, l)) + k][(l - Math.min(i, l)) + k] = true;

                    if((k) < 8 && ((l + i) - k) >= 0 && ((l + i) - k) < 8)
                        testArray[k][(l + i) - k] = true;       
                }
                notFound = false;
             }
         }
     }