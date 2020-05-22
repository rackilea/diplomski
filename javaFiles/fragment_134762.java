for (Line line : getLines("start", "end"))
{
  try
  {
    line.use(cap);
    System.out.println("Line used, great!");
    return true;
  }
  catch (CapacitaSuperataException e)
  {
    System.out.println("Line full, try next");
  }
}
System.out.println("No line found");
return false;