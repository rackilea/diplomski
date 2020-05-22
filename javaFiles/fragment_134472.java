@Override
public final boolean equals(Object obj2)
{
  if (obj2 == this) return true;
  if (!(obj2 instanceof MyClass)) return false;
  MyClass that = (MyClass) obj2;
  return (enum1.equals(that.getEnum1()) && enum2.equals(that.getEnum2()));
}