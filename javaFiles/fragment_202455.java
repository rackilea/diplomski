String [] anArray1 = {red, black, blue, orange, green};
String [][] anArray2 = new String[3][5];

for(int i = 0; i < 3; i++)
{
   for(int q = 0; q < 5; q++)
   {
     anArray2[i][q] = anArray1[q];
   }
}