@Override     
public boolean isNonDescending() {       
   // starting at 1 since we will be looking at data[i-1], which
   // must start at 0. Alternatively, you can write 
   // for (int i=0 ; i < data.length - 1 ; i++) and work with data[i+1]  
   for (int i = 1 ; i < data.length ; i++)     
      if (data[i] > data[i-1]) return true;   
   return false;        
}