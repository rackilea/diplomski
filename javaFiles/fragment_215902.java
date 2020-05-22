public void sortAndFindPairsOfNumbers(int argNumberToFind, int[] array) {                   
        Arrays.sort(array);                                                                     

        System.out.println("\n\nResults of Sort and Find Pairs: \n");                           
        int startIndex = 0;                                                                     
        int endIndex = array.length - 1;                                                        
        int count = 0;                                                                          

        while (startIndex < endIndex) {                                                         
            int sum = array[startIndex] + array[endIndex];                                      
            if (argNumberToFind == sum) {                                                       
                //System.out.println(array[startIndex] + ", " + array[endIndex]);               
                startIndex++;                                                                   
                endIndex--;                                                                     
                count++;                                                                        
            } else if (argNumberToFind > sum) {                                                 
                startIndex++;                                                                   
            } else {                                                                            
                endIndex--;                                                                     
            }                                                                                   
        }                                                                                       
        System.out.println("\nPairs found: " + count + "\n");                                   
    }