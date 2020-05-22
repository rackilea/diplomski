for (int i = 0; i < scores.length; i++) 
{
  for (int a = 0; a < scores[i].length; a++) 
  {
         for (int b = 0; b < scores[i][a].length; b++) 
         {
            scores[i][a][b] = b+1;
         }
   }
}