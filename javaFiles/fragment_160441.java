while (countIncluded != vertices.length) { 

            //u represents a previous i value 
            int u = -1; //value serves as flag for "first time use"  

            //the purpose of this loop is to iterate over included array, which presumably 
            //if of the same length as vertices.
            for (int i = 0; i < vertices.length; i++) { 
                if (!included[i]) { //execute if the value of included[i] is false
                    /* execute if one of these apply:
                       u value is -1 : meaning that it is the first time 
                       included[i] is false (and there is not previous value to compare to).
                       OR C[u] > C[i] : previous vertex value  > current vertex value
                     */
                    if (u == -1 || C[u] > C[i])    
                                      u = i;     //keep i value, the index of the lowest vertex
                                                 //value so far 
                }
            }

            //at the end of the for loop u is the index of the lowest C[u]
            included[u] = true;
            countIncluded++;
     }