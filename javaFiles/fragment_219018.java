public enum Permissions
{
  EDIT,     // 1
  SAVE,     // 2
  DELETE,   // 4
  WHATEVER; // 8

  public long getNumericValue()
  {
     return (1L << ordinal());
  }

};