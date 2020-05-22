class Column<T> {
    public static final Column<String> TEXT_VALUE = new Column<>("Text_Column_Name", String.class);
    public static final Column<Number> NUMERIC_VALUE = new Column<>("Numeric_Column_Name", Number.class);
    public static final Column<Date> DATE_VALUE = new Column<>("Date_Column_Name", Date.class);

    String name;
    Class<T> clazz;

    private Column(String name, Class<T> clazz){
        this.name = name;
        this.clazz = clazz;
    }
}