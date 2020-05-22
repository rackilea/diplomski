String[] values= {"1","1","3","6","2"};     
     Arrays.sort(values);
     int c=1,i=0;
     while(i<values.length-1){
         while(values[i].equals(values[i+1])){
             c++; 
             i++;   
         }   
         System.out.println(values[i] + " appeared " + c + " times");            
         c=1;
         i++;
         if(i==values.length-1)
             System.out.println(values[i] + " appeared " + c + " times");
     }