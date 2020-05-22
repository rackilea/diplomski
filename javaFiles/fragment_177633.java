enum Direction {
   UP(-1, 0),
   DOWN(1, 0),
   LEFT(0, -1),
   RIGHT(0, 1);

   private final int rowSteps;
   private final int colSteps;
   private Direction(int rowSteps, int colSteps)  {
      this.rowSteps = rowSteps;
      this.colSteps = colSteps;
   }
   public int getNewRowIdx(int currentRowIdx)  {
      return  (currentRowIdx + getRowSteps());
   }
   public int getNewColIdx(int currentColIdx)  {
      return  (currentColIdx + getColSteps());
   }
   public int getRowSteps()  {
      return  rowSteps;
   }
   public int getColSteps()  {
      return  colSteps;
   }
};