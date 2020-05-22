count = 0;
       String results = "";

       for(int i=0;i<userString.length();){
           char begin = userString.charAt(i);
           //System.out.println("begin is: "+begin);

           for(int j=i+1; j<userString.length();j++){
               char next = userString.charAt(j);
               //System.out.println("next is: "+next);

               if(begin == next){
                   count++;
               }
               else{
                   System.out.println("Breaking");
                   break;
               }
           }
           i+= count+1;
           if(count>0){
               String add = begin + "";
               int tempcount = count +1;

               results+= tempcount + add;

           }
           else{
               results+= begin;
           }

           count=0;

       }

   System.out.println(results);