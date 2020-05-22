while (current1 != null || current2 != null) {    
   //now check if one of them has ended    
   if (current1 == null) //first ended; insert remaining nodes from second; return result    
   {
        qwe.insertfirst(current2.retcof(),current2.retexp());
        current2 = current2.next;
   }
   if (current2 == null) //second ended, insert remaining nodes from first; return result  
   {
        qwe.insertfirst(current1.retcof(),current1.retexp());  
        current1 = current1.next;
   }
   //otherwise, compare exponents    
   if (current1.retexp() > current2.retexp()) 
   {
        qwe.insertfirst(current1.retcof(),current1.retexp()); 
        current1 = current1.next;
   }    
   //advance the first pointer, but not he second        
   else if (current1.retexp() < current2.retexp())   
   {
        qwe.insertfirst(current2.retcof(),current2.retexp()); 
        current2 = current2.next;
   }
   //in this case advancing the second pointer, but not the first    
   else //exponents are equal                     
   {        
        qwe.insertfirst(current2.retcof()+current1.retcof(),current2.retexp());
        current1 = current1.next; 
        current2 = current2.next;
   }    
   //add the members and advance both pointers    
}