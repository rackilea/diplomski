int i1 = 0;
int i2 = 0;
while (i1 < valueListA.size() && i2 < valueListB.size()) {
   ValueList data1 = valueListA[i1];
   ValueList data2 = valueListB[i2];
   if (data1.getLine_num == data2.getLine_num) {
      // Add the result.
      i1++;
      i2++;
   } else if (data1.getLine_num < data2.getLine_num) {
      // Add -1 because the data was not in valueListB.
      i1++;
   } else {
      i2++;
   }      
}