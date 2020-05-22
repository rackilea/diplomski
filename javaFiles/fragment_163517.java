from java.math import BigDecimal; // money is never float or double.

public static void calculateWage(String name, BigDecimal hourly_rate, int hours) {
    final int OVERTIME_THRESHOLD = 40;
    final int HOURS_LIMIT = 60;
    final BigDecimal MIN_HOURLY_RATE = new BigDecimal("8.00"); 
    // ^^^ again, never store money in a floating point form!


    if (hours > HOURS_LIMIT) {
        // what do you do?
    }

    if (hourly_rate.compareTo(MIN_HOURLY_RATE) < 0) { // less than
        // what do you do?
        // now think how to merge it with previous
    }

    if (hours > OVERTIME_THRESHOLD) {
        int overtime = hours - OVERTIME_THRESHOLD;
        // calculate two values and sum them up
    }
    else { // no overtime
        // calculate just one value
    }
}

public static void main(String[] args) {
    calculateWage("John", new BigDecimal("7.50"), 73);
    calculateWage("Jane", /* well, you see*/);
}