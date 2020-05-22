int []d = {2,18,4,4,6,8,10}; 
int matchNumber = 4 ;
boolean found = false;
for(i= 0; i < d.length; i++)
{ 
    if(matchNumber==d[i]) 
    { 
        System.out.println("Match number " + matchNumber 
                       + " appears in array d at index " + i);
        found = true;
        break;

    }
}

if (!found) System.out.println("-1");