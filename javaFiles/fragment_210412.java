public enum LibType
{
  PRO(
    0,
    1L,
    "PRO"
  ),
  LITE(
    10,
    20L,
    "LITE"
  );

  public final int intVal;
  public final long longVal;
  public final String analyticsCode;

  ...

  private LibType(
      int intVal,
      long longVal,
      String analyticsCode
    )
  {
    this.intVal = intVal;
    ...
  }
}