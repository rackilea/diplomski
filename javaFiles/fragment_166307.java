public class StixBoard
{
  public int totalStix;

  public StixBoard(int number)
  {
    this.totalStix = number;
  }

  public int getNumStix()
  {
    return totalStix;
  }

  public boolean takeStix(int take)
  {
    if(take >= 1 && take <= 3)
    {
      totalStix -= take;
      System.out.println("Number of sticks on board:" + totalStix);
      return true;
    }

    System.out.println("Illegeal Move");
    return false ;
  }

  public boolean isGameOver()
  {
    if(totalStix >=1)
    {
      return(true);
    }
    else
      return false;
  }

  public String toString()
  {
    return(getNumStix() + " Stix Remaining.");
  }
}