int[] pickByAmir(int[] coins, int amirTook, int tamaraTook, int start, int end) {
    if(start>end) {
        int[] res = new int[2];
        res[0] = amirTook;
        res[1] = tamaraTook;
        return res;
    }
    int[] a = new int[2];
    a[0] = amirTook;
    a[1] = tamaraTook;
    if(coins.length==0)
        return a;
    amirTook = coins[start];
    coins = pickByTamara(coins, ++start , end);
    tamaraTook = coins[start];
    a = pickByAmir(coins, amirTook+a[0], tamaraTook+a[1], ++start, end);
    int[] b = new int[2];
    b[0] = amirTook;
    b[1] = tamaraTook;
    if(a[0]<a[1]){
        amirTook = coins[end];
        coins = pickByTamara(coins, start, --end);
        b = pickByAmir(coins, amirTook+b[0], tamaraTook+b[1], ++start, end);
        if(a[0]<b[0])
            return b;
    }
    return a;
}
int[] pickByTamara(int[] coins, int start, int end){
    return coins[start] > coins[end] ? coins : swapArray(coins, start, end);
}

int[] swapArray(int[] coins, int start, int end) {
    int temp = coins[start];
    coins[start] = coins[end];
    coins[end] = temp;
    return coins;
}