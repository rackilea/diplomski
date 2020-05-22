private static final Set<Integer> MONTHS_30_DAYS = Sets.newTreeSet(4, 6, 8, 10, 12);
private static final Set<Integer> MONTHS_31_DAYS = Sets.newTreeSet(1, 3, 5, 7, 9, 11);

public static int numberOfDays(int month, int year) {
   if (MONTHS_30_DAYS.contains(month)) {
      return 30;
   } else if (MONTHS_31_DAYS.contains(month)) {
      return 31;
   } else {
     return (0 == year / 4) ? 29 : 28;
   }
}