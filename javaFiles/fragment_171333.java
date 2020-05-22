@Override
public boolean equals(Object o) {
  if ((o == null) || (o.getClass() != myClass.class)) {
    return false;
  }
  myClass other = (myClass) o;
  return (other.a == this.a) && (other.b == this.b);
}

@Override
public int hashCode() {
  return a * 31 + b;
}