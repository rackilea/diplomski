public static void triples(final int max_values)
{
    int x = 0;
    final StringBuilder sb = new StringBuilder(24000);
    for (int c = 5; c <= max_values; c++)
    {
        final int cTwo = c * c;
        final int b = c - 1;
        final int bTwo = b * b;
        final int cTwoLessB = cTwo - bTwo;

        for (int a = 0; a <= cTwoLessB; a++)
        {
            if (a * a + bTwo == cTwo)
            {
                x++;
                sb.append(x);
                sb.append(") ");
                sb.append(a);
                sb.append(" ");
                sb.append(b);
                sb.append(" ");
                sb.append(c);
                sb.append("\n");
            }
        }
    }
    System.out.println(sb.toString());
}