public static int checksum(int[] data)
{
    if (data.length == 0) {
        return 0;
    }

    int sum = data[0];
    for (int i = 1; i < data.length; ++i) {
        int tmp = data[i];
        tmp = (sum >>> 29) + tmp;
        tmp = (sum >>> 17) + tmp;
        sum = (sum << 3)   ^ tmp;
    }

    return sum;
}