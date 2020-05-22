class Test {
  private static Object[][] createArray(int n, Object[] values)
  {
    Object[][] result = null;
    int m = values.length;
    if (n == 1)
    {
      result = new Object[m][1];
      for (int i = 0; i < m; ++i)
        result[i][0] = values[i];
    }
    else
    {
      Object[][] array = createArray(n - 1, values);
      int l = array.length;
      result = new Object[m * l][n];
      for (int i1 = 0; i1 < m; ++i1)
      {
        for (int i2 = 0; i2 < l; ++i2)
        {
          int i = i1 * l + i2;
          for (int j = 0; j < n; ++j)
            result[i][j] = j == 0 ? values[i1] : array[i2][j - 1];
        }
      }
    }
    return result;
  }

  private static void printArray(Object[][] array)
  {
    System.out.println("{");
    for (int i = 0; i < array.length; ++i)
    {
      System.out.print("  {");
      for (int j = 0; j < array[0].length; ++j)
        System.out.printf(" %s", array[i][j].toString());
      System.out.println(" }");
    }
    System.out.println("}");
  }

  public static void main(String[] args) {
    Object[] values = {'a', 'b', 'c'};
    for (int n = 1; n <= 3; ++n)
    {
      System.out.printf("n = %d:\n", n);
      Object[][] array = createArray(n, values);
      printArray(array);
      System.out.println();
    }
  }
}