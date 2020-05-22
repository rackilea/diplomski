public static int make_change(int money, int coins[]) {
  if (money == 0 || coins.length == 0) {
    return 0;
  }
  return calculate_change(money, coins, 0);
}