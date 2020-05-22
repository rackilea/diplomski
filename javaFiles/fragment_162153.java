int j = 0;
for (int i=0; i< binaryString.length(); i++)
{
  j <<= 1;
  if (binaryString.charAt(i)== '1')
  {
    ++j;
  }
}