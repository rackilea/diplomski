package com.mycompany;

public class SomeClass {
    private static AtomicLong count = new AtomicLong(0);

    public static String getValue(final String key) {
        if (count.getAndIncrement() == 0) { // is this the first call?
            return ""; // don't output a value at system startup
        }
        if ("FULL".equals(key)) {
            // returns info to shown on rollover, nicely formatted
            return fullyFormattedHeader();
        }
        return singleValue(key);
    }
    ....
}