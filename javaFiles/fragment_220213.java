class MaliciousDate {
    private final List<MaliciousDate> dates;
    public MaliciousDate(List<MaliciousDate> dates) {
        this.dates = dates;
    }
    @Override public MaliciousDate clone() {
        MalicousDate other = (MalicousDate)super.clone(); // Or new MalicousDate
        synchronized (dates) {
            dates.add(other);
        }
        return other; // Or return this;
    }
}