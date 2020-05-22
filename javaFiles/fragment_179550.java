public static void gramstoAtoms()
  {
   System.out.println("Enter Amount of grams");
   Scanner keyboard = new Scanner(System.in);
   String x = keyboard.nextLine();
   System.out.println("Enter Unit Grams");
   String y = keyboard.nextLine();
   BigInteger result = new BigInteger(x).divide(new BigInteger(y));
   BigInteger answer = result.multiply(new BigInteger("60200000000000000000000"));
   System.out.println(answer + "Atoms");
  }