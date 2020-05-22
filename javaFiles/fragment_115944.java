...
    // do something with charClass
    unlpCounts[charClass]++
}
for (int i=0; i<unlpStrings.length; i++)
{
    System.out.printf("%s %6d\n",unlpStrings[i],unlpCounts[i]);
}