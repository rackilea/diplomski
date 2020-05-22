int numArrays = 5;
int numElements = 4;
String[][] arrays = new String[numArrays][numElements];
for (int i=0; i<numArrays; i++)
{
    for (int j=0; j<numElements; j++)
    {
        arrays[i][j] = "Hello";
    }
}