int from,to, threadCount = 10;
 boolean check[threadCount];  

 int factor = array.length()/threadCount;
 for(int i = 0; i < threadCount; i++){
      from = i*factor;
      to = i*factor+factor;
      newThreadProcess(from, to, array, check[i]);     
 }

 barrier(); //Wait till all the threads are done processing
 for(int i = 0; i < threadCount; i++){
    if(!check[i]) return false;
 }
 return true;