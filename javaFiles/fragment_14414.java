for (int m = 0; m <= customerName.length-1; m++)
{
     if (customerName[m].equals("Meg"))
     {
           for (int j = m; j < customerName.length; j++)
           {
                 if (j < customerName.length-2)
                 {
                        customerName[j] = customerName[j+1];
                 } else { 
                        customerName[j] = "";
                 }
           }
           m++;
       }
       for (String element : customerName)
       {
            System.out.println(element);
       }
 }