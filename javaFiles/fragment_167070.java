long StartA;
public void actionPerformed( ActionEvent event )
{
    countA++;
    if (countA % 2 != 0)
  StartA = System.currentTimeMillis();

    if (countA % 2 == 0)
    {
         long EndA = System.currentTimeMillis();
         long differenceA = (EndA - StartA);
         System.out.println(differenceA + " Elapsed");
    }