for(int i = strs.length-3; i>=0; i--)  {         

        for(int r = strs.length-7; r>=0; r--) {                

            for(int s = strs.length-5; s>=0; s--) {                   

                for(int t = strs.length-1; t>=3; t--) {                        
                    String temp4 = strs[t];
                    strs[t] = strs[t-3];
                    strs[t-3] = temp4;
                 }   

                String temp3 = strs[s];
                strs[s] = strs[s+4];
                strs[s+4] = temp3;                    
             }

            String temp2 = strs[r];
            strs[r] = strs[r+6];
            strs[r+6] = temp2; 
         }

        String temp = strs[i];
        strs[i] = strs[i+2];
        strs[i+2] = temp;
     }