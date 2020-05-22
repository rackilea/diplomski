public static int calculate_change(int money, int coins[], int start, int total) {
    if (total == money) {
        return 1;
    }
    if (total > money || coins.length == start) {
        return 0;
    }
    return calculate_change(money, coins, 0, total + coins[start]) +
        calculate_change(money, coins, start + 1 total);
}