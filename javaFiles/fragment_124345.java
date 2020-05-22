int[][] data ={ {8,1,25,3,4},{45,12,13,2,3} };  // array of data


    int large = data[0][0];

    for(int i =0 ; i < data.length ; i++)
    {
       for(int j =0 ; j < data[i].length ; j++)
       {
          if(large < data[i][j])
          {
            large= data[i][j];//checking and storing the largest element

          }
       }
    }

  System.out.println("Largest Element :" + large);