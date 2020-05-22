Iterator<String> iter = a.iterator();
if(iter.hasNext()) {
  // first entry with no comma
  System.out.print(iter.next());
}
while(iter.hasNext()) {
  // subsequent entries with a preceding comma
  System.out.print(",");
  System.out.print(iter.next());
}
System.out.println();