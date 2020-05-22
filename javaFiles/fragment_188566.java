public void testMethod() {
    String myArray[] = new String [] { "cook", null, "chef", "baker", null, null, "butcher", null, "distiller" };
    int j = 0;
    for (int i = 0; i < myArray.length; i++) {
        if (myArray[i] != null)  {
            System.out.println(++j + ". " + myArray[i]);
        }
    }