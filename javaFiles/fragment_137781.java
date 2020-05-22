public static void main(final String... args)
{
    final DateTime d = DateTime.now();

    final DateTime d2 = d.minus(Days.days(1)).minus(Minutes.minutes(3));

    long start, end;

    final int count = 5000;
    int i;

    start = System.currentTimeMillis();
    for (i = 0; i < count; i++)
        getFormattedDateDifference(d2, d); // <-- the original implementation
    end = System.currentTimeMillis();

    System.out.println(end - start);

    start = System.currentTimeMillis();
    for (i = 0; i < count; i++)
        getFormattedDateDifference2(d2, d); // <-- the implementation above
    end = System.currentTimeMillis();

    System.out.println(end - start);

    System.exit(0);
}