private static boolean isFinite1(float x) {
    return Float.NEGATIVE_INFINITY < x && x < Float.POSITIVE_INFINITY;
}

private static boolean isFinite2(float x) {
    return !(x != x || x == Float.POSITIVE_INFINITY || x == Float.NEGATIVE_INFINITY);
}


public static void main(String[] args) {
    int nums = 10000;
    int runs = 10000;
    float[] floats = new float[nums];
    for (int i = 0; i < nums; i++) {
        double d = Math.random();
        floats[i] = d < 0.01 ? Float.NaN :
                d < 0.02 ? Float.NEGATIVE_INFINITY :
                        d < 0.03 ? Float.POSITIVE_INFINITY : (float) d;
    }

    for (int n = 0; n < 10; n++) {
        {
            int count1 = 0, count2 = 0;
            long timeA = System.nanoTime();
            for (int i = 0; i < runs; i++)
                for (float f : floats)
                    if (isFinite1(f)) count1++;

            long timeB = System.nanoTime();
            for (int i = 0; i < runs; i++)
                for (float f : floats)
                    if (isFinite2(f)) count2++;

            long timeC = System.nanoTime();

            long total1 = timeB - timeA;
            long total2 = timeC - timeB;
            assert count1 == count2;

            System.out.printf("1,2: isFinite1 took %.1f ns and isFinite2 took %.1f ns on average%n", (double) total1 / runs / nums, (double) total2 / runs / nums);
        }

        {
            int count1 = 0, count2 = 0;
            long timeA = System.nanoTime();
            for (int i = 0; i < runs; i++)
                for (float f : floats)
                    if (isFinite2(f)) count1++;

            long timeB = System.nanoTime();
            for (int i = 0; i < runs; i++)
                for (float f : floats)
                    if (isFinite1(f)) count2++;

            long timeC = System.nanoTime();

            long total1 = timeB - timeA;
            long total2 = timeC - timeB;
            assert count1 == count2;

            System.out.printf("2,1: isFinite1 took %.1f ns and isFinite2 took %.1f ns on average%n", (double) total1 / runs / nums, (double) total2 / runs / nums);
        }
    }
}