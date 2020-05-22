private static final Map<Integer, String> months;
static {
    months.put(1, "January");
    months.put(2, "February");
    months.put(3, "March");
    months.put(4, "April");
    months.put(5, "May");
    months.put(6, "June");
    months.put(7, "July");
    months.put(8, "August");
    months.put(9, "September");
    months.put(10, "October");
    months.put(11, "November");
    months.put(12, "December");
}

public static void monthNumToName(int month) {
    String name = months.get(month);
    if (name == null)
        throw new IllegalArgumentException("Invalid month number: " + month);
    System.out.print(name);
}