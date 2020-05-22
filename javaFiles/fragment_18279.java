public static int dynamicCoinChange(int[] denoms, int amt, int start, ArrayList<Integer> coins) {
    if (amt == 0 || start < 0) {
        return 0;
    } else if (amt == 1) {
        coins.add(1);
        return 1;
    } else if (denoms[start] > amt 
            // Note that these calls are not guaranteed to be in our solution
            // Thus, we make a copy to prevent the calls from modifying our solution
            || dynamicCoinChange(denoms, amt, start-1, new ArrayList<Integer>(coins)) < 
                (1 + dynamicCoinChange(denoms, amt-denoms[start], start, new ArrayList<Integer>(coins))) 
            && !(dynamicCoinChange(denoms, amt, start-1, new ArrayList<Integer>(coins)) == 0)) {
        return dynamicCoinChange(denoms, amt, start-1, coins);
    } else {
        coins.add(denoms[start]);
        return 1 + dynamicCoinChange(denoms,amt-denoms[start], start, coins);
    }
}