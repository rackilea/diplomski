boolean foo = true;
while (foo) {
   DoSomeStuff();

   if (SomeTestOrOther()) {
     foo = false;
   }

   if (foo) {
     DoMoreStuff();
   }
}