Iterator<Integer> i = thisArrayList.iterator();
while (i.hasNext()) {
   int s = i.next(); // must be called before you can call i.remove()
   // Do something
   i.remove();
}