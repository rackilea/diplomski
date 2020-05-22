final UnitFormat uf = UnitFormat.getInstance();
uf.label(NonSI.MILES_PER_HOUR, "miles_per_hour");
AmountFormat.setInstance(new AmountFormat() {

    @Override
    public Appendable format(Amount<?> m, Appendable a) throws IOException {
        TypeFormat.format(m.getEstimatedValue(), -1, false, false, a);
        a.append(" ");
        return uf.format(m.getUnit(), a);
    }

    @Override
    public Amount<?> parse(CharSequence csq, Cursor c) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Parsing not supported.");
    }
});
Amount<Velocity> x = Amount.valueOf(7.5, NonSI.MILES_PER_HOUR);
System.out.println(x);