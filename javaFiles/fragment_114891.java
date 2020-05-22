Iterator<Integer> it = list.listIterator(); 
 if (it.hasNext()) {
   Integer previous = it.next();
   while(it.hasNext()) { 
     Integer current = it.next();
     if (previous.equals(current)) {
       System.out.println("Dupe: " + current);
     }
     previous = current;
   }
 }