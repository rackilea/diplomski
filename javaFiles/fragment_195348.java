private void ClickSquare(int x, int y)
{
   // Did the user click an already exposed square?  If so, ignore
   if (matriz[x][y].getDiscovered()) return;
   matriz[x][y].SetDiscovered(true);
   if (matriz[x][y].getNumberOfMinesAround != 0) return;
   // If empty, click all the neighbors
   for (int xloop = x - 1; xloop <= x + 1; xloop++)
       for (int yloop = y - 1; yloop <= y + 1; yloop++)
           ClickSquare(xloop, yloop);
}