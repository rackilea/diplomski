boolean shouldRetry = true;

while(shouldRetry) {

     try {
        action(); 
        shouldRetry= false;
      } catch(Exception e) {
        shouldRetry= true;                
      }
}