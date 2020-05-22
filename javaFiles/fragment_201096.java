public static boolean hasDistinctDigits(int number)
{
    final Set<Integer> set = new HashSet<Integer>();

    while (number > 0) {
        if (!set.add(number % 10))
            return false;
        number /= 10;
    }

    return true;
}