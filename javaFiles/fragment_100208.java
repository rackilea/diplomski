// Readers might do:
synchronized (list) {
  itr = nodeAttributes.listIterator();
  while (i.hasNext())
      ... do stuff ...
}