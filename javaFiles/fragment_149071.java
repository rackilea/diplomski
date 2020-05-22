String forms = "[436,43,4,436,43,44]"; 
           forms=forms.replace("[", "");
           forms=forms.replace("]", "");
           String resultArray[]=forms.split(",");

           for(int i=0; i<resultArray.length;i++)
           {

               System.out.println(i + ") " + resultArray[i]);


           }
           System.out.println("Counter" + resultArray.length);