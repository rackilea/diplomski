public String display() {
  StringBuilder sb = new StringBuilder();
  Iterator i = properNumber.iterator();
  while(i.hasNext()){
   sb.append(i.next);
   sb.append("\n");
  }

  return sb.toString();
}