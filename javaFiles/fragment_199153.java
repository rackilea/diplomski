while (value <= max)
    {     
       if ((value % 5) < 1 ^ (value % 6) < 1){
          System.out.print (value + " ");
          count++;
          if (count % PER_LINE == 0)
              System.out.println();     
       }
       value++;
    }