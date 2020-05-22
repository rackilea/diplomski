List<myObj> newresults = new ArrayList<myObj>();

 Iterator<myObj> iter = results.iterator();
 while (iter.hasNext()) {
   myObj lies = iter.next();
   if (lies.isLiesIn() == true) {
          newresults.add(lies);
   }
 }
 // if no true element was added - the list contained only false
 if (newresults.size()==0 && results.size()>0) {
     newresults.add(results.get(0));
 }