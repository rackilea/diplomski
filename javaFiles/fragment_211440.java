public void increment() {
    for (int i = BigInteger.length - 1; i; i--)
      if (BigInteger[i] < 9) {
        BigInteger[i]++;
        for (int j = i + 1; j < BigInteger.length; j++)
          BigInteger[j] = 0;
        break;
      }
      else if (i == 0)
        // cannot increment 9
}

public void decrement() {
    for (int i = BigInteger.length - 1; i; i--)
      if (BigInteger[i] > 0) {
        BigInteger[i]--;
        for (int j = i + 1; j < BigInteger.length; j++)
          BigInteger[j] = 9;
        break;
      }
      else if (i == 0)
        // cannot decrement 0
}