int Number[][] = new int[10][4];
int Cards[] = new int[10];
int Slots[] = new int[9];

for (int y = 0; y < 10; y++)
{
    for (int z = 0; z < 4; z++)
    {
        iCards = y;
        iNumInCards = z;
        iNum = Numbers.nextInt(10) + 1;
        Number[iCards][iNumInCards] = iNum;
    }
}