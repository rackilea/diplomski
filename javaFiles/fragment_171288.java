public static void main(String[] args) {
    Integer[] array = new Integer[] { 3, 2, -4, -7 };
    ArrayList arrayList = new ArrayList(Arrays.asList(array));
    System.out.println(averagePositive(arrayList));
}

public static double averagePositive(ArrayList<Integer> values) {
    if (values == null || values.isEmpty())
        return 0.0;

    int sum = 0;
    int n = 0;

    for (int i = 0; i < values.size(); i++)
        if (values.get(i) > 0.0) {
            sum += values.get(i);
            n++;
        }

    return ((double) sum) / n;
}