Calendar ca = Calendar.getInstance(); // this is NOW

// set the date to the first of the month, to avoid surprises if the current date is 31.
ca.set(Calendar.DAY_OF_MONTH, 1);

// go n months before the first of this month
ca.add(Calendar.MONTH, -n);

for (int i = 0; i < n; i++) {
    // todo: format the date as you want and print it. See SimpleDateFormat

    // go to the next month
    ca.add(Calendar.MONTH, 1);
}