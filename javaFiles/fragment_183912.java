public static void main(String[] args)
  {
    int[] tree = new int[] { 3, 2, 2 };

    System.out.println(max_independant_weight(tree));
  }

  private static int max(int[] array)
  {
    int max = Integer.MIN_VALUE;

    for (int i : array)
    {
      if (i > max)
      {
        max = i;
      }
    }

    return max;
  }

  private static int max_independant_weight(int[] weights)
  {
    return max(with_and_without(weights, 0));
  }

  private static int[] with_and_without(int[] weights, int i)
  {
    if (i >= weights.length)
    {
      return new int[] { 0, 0 };
    }
    int[] left = with_and_without(weights, (2 * i) + 1);
    int[] right = with_and_without(weights, (2 * i) + 2);
    return new int[] { weights[i] + left[1] + right[1], max(left) + max(right) };
  }