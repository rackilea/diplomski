class Main
{
    // using Sieve of Eratosthenes to factorize all numbers
    public static int[] computeDivs(int size) {
      int[] divs = new int[size + 1];
      for (int i = 0; i <  size + 1; ++i) {
        divs[i] = 1;
      }
      int o = (int)Math.sqrt((double)size);
      for (int i = 2; i <= size; i += 2) {
        divs[i] = 2;
      }

      for (int i = 3; i <= size; i += 2) {
        if (divs[i] != 1) {
          continue;
        }
        divs[i] = i;
        if (i <= o) {
          for (int j = i * i; j < size; j += 2 * i) {
            divs[j] = i;
          }
        }
      }
      return divs;
    }

    // Counting the divisors using the standard fomula
    public static int countDivisors(int x, int[] divs) {
      int result = 1;
      int currentDivisor = divs[x];
      int currentCount = 1;
      while (currentDivisor != 1) {
        x /= currentDivisor;
        int newDivisor = divs[x];
        if (newDivisor != currentDivisor) {
          result *= currentCount + 1;
          currentDivisor = newDivisor;
          currentCount = 1;
        } else {
          currentCount++;
        }
      }
      if (x != 1) {
        result *= currentCount + 1;
      }

      return result;
    }


    public static int countAllDivisors(int upTo) {
      int[] divs = computeDivs(upTo + 1);
      int result = 0;
      for (int i = 1; i <= upTo; ++i) {
        result += countDivisors(i, divs);
      }
      return result;

    }

    public static void main (String[] args) throws java.lang.Exception {
      System.out.println(countAllDivisors(15));
    }
}