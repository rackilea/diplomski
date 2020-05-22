...
        else if (arr[i] > secondLargest && arr[i] != largest) 
                                        --------------------
        { 
            thirdLargest = secondLargest; 
            secondLargest = arr[i]; 
        } 

        else if (arr[i] > thirdLargest && arr[i] != largest && arr[i] != secondLargest) 
                                       -----------------------------------------------
            thirdLargest = arr[i]; 
        ...