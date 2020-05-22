Calendar cal;
int[] years = new int[15];

public int[] getYears() {
    cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    for (int index = 0; index < years.length;) {
        years[index++] = year + index;
    }
    return years;
}