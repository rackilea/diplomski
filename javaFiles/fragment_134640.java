List<String> items = ....
Iterator<String> it = items.iterator();
while (it.hasNext()) {
   String s = it.next(); 
    if (s.length() % 2 == 0){
         it.remove();
     }

}