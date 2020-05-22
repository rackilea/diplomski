for (int i = 0; i < anArray.length; i++) {
  System.out.print("\nThe items for index[" + i + "]: ");

  if (anArray[i] != null) {
    MyList tmp = anArray[i];
    while ((tmp = tmp.next) != null) {
      System.out.print(tmp.iData + " ");
    }
  }
}