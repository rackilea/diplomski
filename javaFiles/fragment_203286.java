int age, year;
for (year = 1893; year <= 2139; year++) {
    for (age = 0; age <= 123; age++) {
        System.out.println(age + "= " + age * age + " ");

        if (MIN_YEAR <= (age * age) && (age * age) <= MAX_YEAR) {
            JOptionPane.showMessageDialog(null, "It is possible that someone  alive   today "
                    + "has, is, or will be     alive in a year that is the square of their age.");

            if (age * age == year) {
                System.out.println("Age is:" + age + "Year is:" + year);
            }
        }
    }

}