String[] tempsArray = temps.toArray(new String[74]);
int[] myIntArray = new int[tempsArray.length];
for (int i = 0; i < tempsArray.length; i++) {
  myIntArray[i] = Integer.parseInt(tempsArray[i].substring(2), 16);
  System.out.println(myIntArray[i]);
}