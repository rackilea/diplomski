System.out.println("\nResults of Find Pairs: \n");                                      
        long randomInt1 = 0;                                                                    
        int randomInt2 = 0;                                                                     
        int count = 0;                                                                          
        for (int i = 0; i < array.length - 1; i++) {                                            
            for (int j = i + 1; j < array.length; j++) {                                        
                int sum = array[i] + array[j];                                                  
                if (argNumberToFind == sum) {                                                   
                    count++;                                                                    
                }                                                                               
            }                                                                                   
        }                                                                                       
        System.out.println("\nPairs found: " + count + "\n");