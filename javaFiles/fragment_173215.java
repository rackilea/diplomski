@Override
public boolean equals(Object obj)
{
  if (!(obj instanceof DynamicField))
     return false;
  return compareTo((DynamicField)obj) == 0;
}