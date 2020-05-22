class Example {

  static int[] result; 

  public static void main(final String[] args) {
      result = constructArray(arrayA,arrayB);
      System.out.println(Arrays.toString(result));
      int variable = get(2);
      System.out.println(variable);
  }

  public static int get(int var)  {
      return result[var];
  }

}