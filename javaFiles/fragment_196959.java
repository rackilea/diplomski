int r = 1;  //radius, in case you want to use median over a larger kernel

for(int y = r; y < height - r; y++)
{
   for (int x = r; x < width - r; x++)
   {
      for(int j = y - r; j <= y + r; j++)
      {
         for(i = x - r; i <= x + r; i++)
         {
            //get all neighborhood values 
         } 
      }    

      //find median
   }
}