public String toString(){
  String s = id + "";
  if(next != null)
    s += ", " + next.toString();
  return s;
}