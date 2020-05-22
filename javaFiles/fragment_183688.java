public void AverageStudent(int[][] book) //columns
       {
           double average1,sum1;

          for (int i = 0; i < book[0].length; i++)
          {     sum1 = 0;
                average1 = 0;
            for (int k = 0; k < book.length; k++)
            {
                sum1 += book[k][i];               
            }
               average1 = sum1 / book.length;
               System.out.println("The average of student " + (i+1) + " is " + average1);
          }
       }