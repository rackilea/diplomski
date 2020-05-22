boolean shouldRetry= false;

 do {

  try {
    action(); 
    shouldRetry= false;
  } catch(Exception e) {
    shouldRetry= true;                
  }

 }while(shouldRetry)