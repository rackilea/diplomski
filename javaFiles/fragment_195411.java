String s;
Iterator<String> iter = l.iterator();  // l is a list of strings
while (iter.hasNext()) {
    s = iter.next();
    System.out.println(s);
}