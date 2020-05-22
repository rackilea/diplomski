for(int i = 0; i < 100; i++)
{
   // Create a new object on the stack
   Object o = Object(); // Note we're not using the new keyword here.

   // Do something with object

   // Object gets automatically deallocated, or more accurately, in this specific
   // case (a loop), the compiler will optimize things, so object's destructor
   // will get called, but the object's stack memory will be reused.
}