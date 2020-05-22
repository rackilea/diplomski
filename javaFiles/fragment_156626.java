byte[] bArray = trs.getByteArrayValue(columnArray[j]);
//  value = new String(bArray);   // returns some char non readable

for (int k = 0; k < bArray.length; k++) 
{
    value += bArray[k];
}

System.out.print(value + ";");