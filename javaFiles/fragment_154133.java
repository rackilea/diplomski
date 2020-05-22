/* 
    ...
 */
bool[] printed = new bool[countries.length];

for(int i=0 ; i<numOfTimes ; /*noop*/ )
{
      int r = nums.nextInt(countries.length);
      if (printed[r] == false) 
      {
          i = i + 1;
          printed[r] = true;
          aTemp = aTemp + countries[r];
          aTemp = aTemp + ",";  
      }
}
return aTemp;