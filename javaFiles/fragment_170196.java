public static int max(int... nums) {
    int max = Integer.MIN_VALUE;
    for(int i: nums) if(max < i) max = i;
    return max;
}

int[] player1,player2,player3,player4;
....
int allMax = max(max(player1), max(player2), max(player3), max(player4));