private static final String [] COLUMN_NAMES = new String[]{"date","customerNumber","customerName",
        "account","emailAdress","mobilePhoneNumber","emailStatus"};

protected static List<String> getColumnNames() {
    return Collections.unmodifiableList(Arrays.asList(COLUMN_NAMES));
}