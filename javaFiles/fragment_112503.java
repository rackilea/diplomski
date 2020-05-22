Observable
   .from(modifications)
   .flatmap( (data1) -> { 
       return op1(data1)
           ...
           .flatmap( (data2) -> { 
               // I can access data1 here
               return op2(data2);
           })
   });