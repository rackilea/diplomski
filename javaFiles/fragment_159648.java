public static void main (String args[])
{
  int count=0;
  int [] myArray= new int[13];
  int z=0;
  for(int i=2;i<=myArray.length;i++) {
    z=valuegetter(i);
    System.out.println(z);
    arraycounter(myArray, z, i);

  }
  for (int i=0; i < myArray.length; i++) {
      System.out.print(myArray[i] + ", ");
  }
}