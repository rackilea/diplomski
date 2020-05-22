import java.util.Random;

//...

private static final Random random = new Random(); // be careful with multiple threads

public static int nextRandom(int maxValueExclusive)
{
    return random.nextInt(maxValueExclusive);
}

public static long nextRandom(long maxValueExclusive)
{
    //implementation from java 1.7 ThreadLocalRandom
    if (maxValueExclusive <= 0)
        throw new IllegalArgumentException("argument must be positive: " + maxValueExclusive);
    // Divide n by two until small enough for nextInt. On each
    // iteration (at most 31 of them but usually much less),
    // randomly choose both whether to include high bit in result
    // (offset) and whether to continue with the lower vs upper
    // half (which makes a difference only if odd).
    long offset = 0;
    while (maxValueExclusive >= Integer.MAX_VALUE) {
        long half = maxValueExclusive >>> 1;
        long nextn = random.nextBoolean() ? half : maxValueExclusive - half;
        if (random.nextBoolean())
            offset += maxValueExclusive - nextn;
        maxValueExclusive = nextn;
    }
    return offset + random.nextInt((int) maxValueExclusive);
}

public static double nextRandom(double maxValueExclusive)
{
    if (maxValueExclusive <= 0)
        throw new IllegalArgumentException("argument must be positive: " + maxValueExclusive);
    return random.nextDouble()*maxValueExclusive;
}

public static float nextRandom(float maxValueExclusive)
{
    if (maxValueExclusive <= 0)
        throw new IllegalArgumentException("argument must be positive: " + maxValueExclusive);
    return random.nextFloat()*maxValueExclusive;
}

public static boolean nextRandom(boolean unusedValue)
{
    return random.nextBoolean();
}