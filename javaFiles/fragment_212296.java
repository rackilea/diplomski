class FeeSchedule {
    static class Entry implements Comparable<Entry> {
        int threshold;
        int percentage;

        int compareTo(Entry other) {
            // sort by percentage, descending
        }

    SortedSet<Entry> feeTable;

    int calculateFee(int invoiceAmount) {
        for(Entry e : feeTable)
            if(invoiceAmount > e.threshold)
                return (invoiceAmount * e.percentage);

        // error condition; return 0?
    }
}