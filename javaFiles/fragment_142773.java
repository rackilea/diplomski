public int busiestHour2()
{
   int max = hourCounts[0];
   int counter = 0;
   int index = 0;
   for(int hourCount : hourCounts){
       if(max < hourCount){ 
          max = hourCount;
          counter = index;          
       }
       index = index + 1;
    }
   return counter;
}