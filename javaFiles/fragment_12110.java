public static void main(String[] args) {
  int search;
  boolean found = false;
  int num[]={3, 4, 5, 6, 7, 8, 10, 7,  9, 13};

  System.out.print("Array: ");
  for (int count=0; count<num.length; count++)
      System.out.print(+num[count] + " ");

  Scanner in = new Scanner (System.in);
  System.out.print("\nValue to find: ");
  search = in.nextInt();

  for (int counter = 0; counter < num.length; counter++ ) {
      if (num[counter] == search)
      {
        System.out.println(search + " is in slot " + (counter + 1) + ".");
        found = true;
      }           
  }

  if (!found) {
        System.out.println(search + " is not in the array.");
  }

  in.close();

}