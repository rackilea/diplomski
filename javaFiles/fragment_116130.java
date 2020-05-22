public class FakeTimeZone extends DateTimeZone {

    private DateTime dstStart;

    private DateTimeZone zone;

    protected FakeTimeZone(String id) {
        super(id);
        this.zone = DateTimeZone.forID(id);
        // DST starts at 21/Feb/2018, at 4 PM 
        this.dstStart = new DateTime(2018, 2, 21, 16, 0, 0, 0, zone);
    }

    @Override
    public String getNameKey(long instant) {
        return this.getID();
    }

    @Override
    public int getOffset(long instant) {
        // check if it's in DST
        if (dstStart.getMillis() <= instant) {
            // DST, offset is 1 hour ahead the standard - value must be in milliseconds
            return this.zone.getStandardOffset(instant) + 3600000;
        }
        return this.zone.getStandardOffset(instant);
    }

    @Override
    public int getStandardOffset(long instant) {
        return this.zone.getStandardOffset(instant);
    }

    @Override
    public boolean isFixed() {
        return false;
    }

    @Override
    public long nextTransition(long instant) {
        if (instant < dstStart.getMillis()) {
            return dstStart.getMillis();
        }
        return instant;
    }

    @Override
    public long previousTransition(long instant) {
        if (instant > dstStart.getMillis()) {
            return dstStart.getMillis();
        }
        return instant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FakeTimeZone) {
            return getID().equals(((FakeTimeZone) obj).getID());
        }
        return false;
    }
}