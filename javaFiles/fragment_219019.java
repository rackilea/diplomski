public long getLong(EnumSet<Permissions> flags)
{
  long result;
  result = 0;
  for (Permissions element: flags)
    result += element.getNumericValue();
  return (result);
}