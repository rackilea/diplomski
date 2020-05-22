Collection c = Collections.synchronizedCollection(myCollection);
 ...   
  synchronized (c) {
  Iterator i = c.iterator(); // Must be in the synchronized block
  while (i.hasNext())
     foo(i.next());   
  }