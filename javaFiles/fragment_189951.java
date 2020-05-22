else{//THIS ELSE PART IS HAVING SOME PROBLEM.
                //if length of string is greater than 18digits
                //it will compare two string character by character to find 
                //the larger string or if they are equal.
                char[] c1 = L[i].toCharArray();
                char[] c2 = R[j].toCharArray();
                int c1leng= c1.length;
                int c2leng= c2.length;
                //int shorter= c1leng < c2leng ? c1leng : c2leng ;
                if(c1leng==c2leng){
                    for(int p=0; p<c1leng; p++){
                    if(c1[p]==c2[p]){
                        if(p == c1leng-1) {
                            arr[k] = L[i];
                            i++;
                            break;
                        }
                        continue;
                    }else if(c1[p]<c2[p]){
                        arr[k] = L[i];
                        i++;
                        break;
                    }else if(c1[p]>c2[p]){
                        arr[k] = R[j];
                        j++;  
                        break;
                    }
                    }
                }else{
                    arr[k] = L[i]; //here was the problem. I was assigning R[j] instead of L[i] which was pushing larger elements alternatively.
                    i++;       
                }
            }