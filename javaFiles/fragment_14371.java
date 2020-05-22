enum Month {
    JANUARY(31),
    FEBRUARY(28) {
        @Override
        public int getNumberOfDays(int year) {
            return isLeapYear(year) ? 29 : 28;
        }

        private boolean isLeapYear(int year) {
            return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        }
    },
    MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31),
    AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

    private final int numberOfDays;

    Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays(int year) {
        return numberOfDays;
    }
}