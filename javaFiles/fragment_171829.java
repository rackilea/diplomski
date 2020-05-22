int max = array[0];
 for (int counter = 1; counter < array.length; counter++)
        {
             if (array[counter] > max)
             {
              max = array[counter];
             }
        }

    System.out.println("The maximum number is: " + max);