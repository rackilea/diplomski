public static void main(String[] args) {
    int[] denoms = {1, 6, 10, 25};
    ArrayList<Integer> coins = new ArrayList<Integer>();
    int numCoins = dynamicCoinChange(denoms, 7, 3, coins);
    for (Integer coin : coins)
        System.out.println(coin);
    System.out.println(numCoins);
}