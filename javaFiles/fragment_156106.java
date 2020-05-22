Iterator<Foo> iterator = myFooSet.iterator();
while (iterator.hasNext()) {
   Foo myFoo = iterator.next(); // get current item

   // check if current item's properties match two searched for 
   // properties
   if (myFoo.getBar.equals(someBar) && myFoo.getBaz.equals(someBaz)) {
       iterator.remove();
   }
}