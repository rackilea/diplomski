Object[] arr = FileRead.doRead().toArray();
Object[][] data = new Object[arr.length/2][2];
for (int x = 0; x < arr.length; x+=2){
   data[x/2][0]=arr[x];
   data[x/2][1]=arr[x+1];
}
return data;