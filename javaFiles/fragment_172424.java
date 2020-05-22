private static final String[] months = {
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
};

public static void monthNumToName(int month) {
    if (month < 1 || month > 12)
        throw new IllegalArgumentException("Invalid month number: " + month);
    System.out.print(months[month-1]);
}