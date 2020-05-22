public static void main(String[] args) throws Exception {
    Partial pa = new Partial().with(DateTimeFieldType.halfdayOfDay(), 1).with(DateTimeFieldType.hourOfHalfday(), 3)
            .with(DateTimeFieldType.minuteOfHour(), 34);
    Period pr = new Period(zeroWithMatchingFields(pa), pa);
    p(pr.getHours()); // Returns 15
}

public static Partial zeroWithMatchingFields(ReadablePartial in) {
    AbstractPartial ap = in instanceof AbstractPartial ? (AbstractPartial) in : new Partial(in);
    int[] zeros = new int[ap.size()];
    return new Partial(ap.getFieldTypes(), zeros, in.getChronology());
}