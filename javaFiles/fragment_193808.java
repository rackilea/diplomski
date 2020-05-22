Cell[][] nextGen = new Cell[universe.length][universe[0].length];
for(int r = 0; r < nextGen.length; r++)
{
   for(int c = 0; c < nextGen[0].length; c++)
   {
         nextGen[r][c] = new Cell(/*provide arguments such that this cell stores the same info as universe[r][c]*/);
   }
}