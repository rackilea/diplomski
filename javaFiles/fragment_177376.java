volatile String _field;

public int getFieldLength() {
  String tmp = _field;
  if(tmp != null) {
    return tmp.length();
  }
  return 0;
}