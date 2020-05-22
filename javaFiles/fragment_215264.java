int countLegs ( List< ? extends Animal > animals )
{
   int retVal = 0;
   for ( Animal cur : animals )
   {
      retVal += cur.countLegs( );
   }

   return retVal;
}