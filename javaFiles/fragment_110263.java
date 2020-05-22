if(cpoies[i] < 20 ){
            for(int j=i;j<cpoies.length-1;j++)
               cpoies[j]=cpoies[j+1];
            --numOfNumbers;
            i--;
         }}