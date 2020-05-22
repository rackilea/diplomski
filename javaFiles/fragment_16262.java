for (int i = 1; i < 4;i++)
{    
  //do action here
  int[] counters = new int[6];

  for (int j = 0; j < myTableNbRows; i++)
  {
    if (myTable.getValue(j, 0).matches("hello"))
    {
      if (myTable.getValue(j, 1).contains("tions."))
      {
        counters[0]++;
      }
    ...
    ...
    }

   for (int t = 0; t<counters.length; t++) {
     assertEquals(values[i][t], counters[t]);
   }
   // or preferred method
   assertThat(counters, IsArrayContainingInOrder.arrayContaining(values[i]));
}