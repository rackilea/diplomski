public static int getMonth(String str) throws InvalidMonthException {
    int month = Integer.parseInt(str);
    if (month < 1 || month > 12) {
        throw new InvalidMonthException(month);
    }
    return month;
}