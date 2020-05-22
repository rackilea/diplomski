// days in joda time are 1 based so 0 won't be used here
private static final int[] daysShift = new int[] = {0, 0, -1, -2, -3, 3, 2, 1};
...
iDate = iDate.minusYears(1);
// based on the current day, shift us by a certain number of days, + or -
iDate.plusDays(daysShift[iDate.getDayOfWeek()]);