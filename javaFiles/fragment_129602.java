for(Super currentSuper : supers)  
{  
    if(currentSuper instanceof SubA)  
    {  
         SubA subA = (Suba) currentSuper);  
         // do stuff with subA
    }  
    else if(currentSuper instanceof SubB)  
    {  
         SubB subB = (SubB) currentSuper);  
         // do stuff with subB
    } 
}