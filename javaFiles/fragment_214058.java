import java.util.concurrent.ThreadLocalRandom;

//...

public static int nextRandom(int maxValueExclusive)
{
    return ThreadLocalRandom.current().nextInt(maxValueExclusive);
}

public static long nextRandom(long maxValueExclusive)
{
    return ThreadLocalRandom.current().nextLong(maxValueExclusive);
}

public static double nextRandom(double maxValueExclusive)
{
    return ThreadLocalRandom.current().nextDouble(maxValueExclusive);
}

public static float nextRandom(float maxValueExclusive)
{
    if (maxValueExclusive <= 0)
        throw new IllegalArgumentException("argument must be positive: " + maxValueExclusive);
    return ThreadLocalRandom.current().nextFloat()*maxValueExclusive;
}

public static boolean nextRandom(boolean unusedValue)
{
    return ThreadLocalRandom.current().nextBoolean();
}