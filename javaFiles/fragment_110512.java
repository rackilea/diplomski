// your class's constructor should have exactly four arguments
// and ensure that each of these four fields are non-null

@Override
public int hashCode() {
  return 37
    ^ int_col1.hashCode()
    ^ int_col2.hashCode()
    ^ bigint_col1.hashCode()
    ^ bigint_col2.hashCode();
}

@Override
public boolean equals(Object that) {
  if (this == that) {
    return true;
  }
  if (that == null) {
    return false;
  }
  if (!(that instanceof YourPrimaryKeyClass)) {
    return false;
  }
  YourPrimaryKeyClass other = (YourPrimaryKeyClass) that;
  return this.int_col1.equals(other.int_col1)
    && this.int_col2.equals(other.int_col2)
    && bigint_col1.equals(other.bigint_col1)
    && bigint_col2.equals(other.bigint_col2);
}