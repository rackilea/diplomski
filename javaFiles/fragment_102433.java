// Parent:
@Override
public final int compareTo(Parent other)
{
  if (getClass() == other.getClasss()) {
    // same type -> pass it to subclass implementation
    return this.subCompare(other)
  }

  // different type -> do the comparison here based on Parent's logic
  // ...
}

protected int subCompare(Parent other)
{
  // this should not be called directly
  return 0; // could throw an exception here too
}

// Derived1:
@Override
protected int subCompare(Parent other)
{
  // this method is only called from Parent
  Derived1 other1 = (Derived1) other;
  // do the comparison based on Derived1's logic
}