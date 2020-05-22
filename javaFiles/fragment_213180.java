public static void zeroDistance (int [] a) {
    // closest == -1 means no zero was found yet
    int closest = -1;
    for (int i=0 ; i<a.length ; i++) 
       if (a[i] == 0) 
           closest = 0;
       else {         
           // short version
           // a[i] = closest == -1 ? Integer.MAX_VALUE : ++closest;

           // simpler version for your to understand
           if (closest == -1) 
               a[i] = Integer.MAX_VALUE;
           else {
               closest++;
               a[i] = closest;
           }                    
       }
    closest = -1;
    for (int i=a.length-1 ; i>=0 ; i--) 
       if (a[i] == 0)                            
           closest = 0;
       else if (closest != -1 && a[i] > ++closest) 
           a[i] = closest;       
}