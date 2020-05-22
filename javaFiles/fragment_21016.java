for(int i = 0; i < 100; i++)
{
   // Dynamically allocate an object
   Object* o = new Object();

   // do something with object

   // Release object memory (and call object destructor, if there is one)
   delete o;
}