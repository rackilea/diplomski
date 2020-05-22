else if(respons == higher)
 {  
    min = min + 1;
    getMidpoint(min,max);
 }
else if(respons == lower)
 {
    max = min - 1;
    getMidpoint(min,max);           
 }