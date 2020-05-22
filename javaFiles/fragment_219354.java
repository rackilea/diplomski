public int[] getHungryPeople()
{
   // Get hungry people data from the class's Android Intent field
   final int[] values = mIntent.getIntArrayExtra( HUNGRY_PEOPLE );

   if ( null != values )
   {
        return Arrays.copyOf( values, values.length );
   }

   // if values is null, return null
   return null;
}