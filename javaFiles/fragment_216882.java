private void addOrd(String ord){
    boolean found = false;
    for (int i = 0; i < list.size(); i++){
      //You need to comapre te tekst field not the object
      if (list.get(i).tekst.toString().equalsIgnoreCase(ord)) {
         found = true;
         break;
      }
   }
if(!found){
    Ord nyOrd = new Ord(ord);
    list.add(nyOrd);
 }