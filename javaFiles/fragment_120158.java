public Calendar[] getYears() {
    cal = Calendar.getInstance();
    for (int index = 0; index < years.length;) {
        years[index++] = (Calendar) cal.clone();
        cal.add(Calendar.YEAR, 1);
    }
    return years;
}