//pseudocode
String line;
StringBuilder toFile = new StringBuilder();
int i=0;
for (;array.length>0 && i<array.length-2;i++){
   toFile.append("%d ",array[i]);
}

toFile.append("%d",array[i]);

fileOut.write(toFile.toString());