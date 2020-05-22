public static int[] go(int[] ray)
{
    int[] res = new int[]{0,0,0};
    int count = 0;
    for (int i = 0; i < ray.length && count < 3; i++) {
        if ( ray[i] > 11 ) {
            res[count++] = ray[i];
        }
    }
    return res;
}