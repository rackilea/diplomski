struct MutableInteger{
  public MutableInteger(int v) { this.value = value;}
  public int value;
}

public void swap3( MutableInteger k, MutableInteger l, MutableInteger m) {
  int t = m.value;
  m.value = l.value
  l.value=k.value;
  k.value=t;
}